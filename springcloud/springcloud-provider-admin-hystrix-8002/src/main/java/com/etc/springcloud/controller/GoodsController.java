package com.etc.springcloud.controller;

import com.alibaba.fastjson.JSON;
import com.etc.springcloud.pojo.Goods;
import com.etc.springcloud.pojo.Type;
import com.etc.springcloud.pojo.User;
import com.etc.springcloud.service.GoodsService;
import com.etc.springcloud.service.TypeService;
import com.etc.springcloud.tools.Constants;
import com.github.pagehelper.PageInfo;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @Resource
    private TypeService typeService;
//查询商品
    @RequestMapping("/goodsList")
    @ResponseBody
    public String GoodsList(String name,String pageIndex){
        int pageSize= Constants.pageSize;
        int currentPageNo=1;
        if(pageIndex!=null&&pageIndex!="") {
            currentPageNo=Integer.valueOf(pageIndex);
        }else {
            currentPageNo=1;
        }
        PageInfo<Goods> pages =goodsService.getGoodsList(name, currentPageNo, pageSize);
//        List<Type> typeList=typeService.queryTypeList();
        Map<String, Object> map=new HashMap<String, Object>();
//        map.put("typeList",typeList);
        map.put("pages", pages);
        return JSON.toJSONString(map);
    }

    @RequestMapping("/goodsListById")
    @ResponseBody
    public String GoodsList(int gid,int tid ){
        Map<String, Object> map=new HashMap<String, Object>();
        Goods goods=goodsService.queryGoodsById(gid);
        Type type=typeService.queryTypeById(tid);
        List<Type> typeList=typeService.queryTypeList();
        if(goods!=null && typeList!=null){
            map.put("goods",goods);
            map.put("type",type);
            map.put("typeList",typeList);
        }else{
            map.put("flag","false");
        }
        return JSON.toJSONString(map);
    }
    //添加商品
    @PostMapping(value="/addGoods",produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String addGoods(HttpServletRequest request,String gname, String goodstype, Double price,Double discount ,int stock, String details, @RequestParam(value="attachment",required = false) MultipartFile attachment) {
        int tid= Integer.valueOf(goodstype);
        String image = null;
        Map<String, Object> map = new HashMap<String, Object>();
        //获取文件原文件名
        String oldFileName = attachment.getOriginalFilename();
        //定义我们对应上传的文件路径
        //File.separator表示自动读取操作系统上面的目录分隔符
        String path = "F:\\Project\\management\\upload\\";
        //获取文件的扩展名
        String subfix = FilenameUtils.getExtension(oldFileName);
        int fileSize = 500000;//文件限制大小为500K
        if (attachment.getSize() > fileSize) {
            request.setAttribute("uploadFileError", "上传失败，图片太大！");
            map.put("flag", "false");
        } else if (subfix.equalsIgnoreCase("jpg")
                || subfix.equalsIgnoreCase("jpeg")
                || subfix.equalsIgnoreCase("png")
                || subfix.equalsIgnoreCase("gif")) {//判断文件是否符合指定类型
            Random random = new Random();
            String fileName = System.currentTimeMillis() + random.nextInt(10) +"."+ subfix;
            File targetFile = new File(path,fileName);//根据新文件名创建一个新目录
            /*if (!targetFile.exists()) {//不存在则创建
                targetFile.mkdir();
            }*/
            try {
                attachment.transferTo(targetFile);
                image ="upload/" +fileName;
            } catch (IOException e) {
                e.printStackTrace();
                map.put("flag", "false");
            }
            /*****************************文件上传结束********************************************/
            if(goodsService.addGoods(gname,tid,price,discount,stock,details,image)>0){
                map.put("flag", "true");
            }
        }
        return JSON.toJSONString(map);
    }
//修改商品信息
    @PostMapping(value="/modifyGoods",produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String modifyGoods(HttpServletRequest request,int gid, String gname, String goodstype, Double price,Double discount, int stock, String details, @RequestParam(value="attachment",required = false) MultipartFile attachment) {
//        Goods goods = new Goods();
        int tid= Integer.valueOf(goodstype);
        String image = null;
        Map<String, Object> map = new HashMap<String, Object>();

        //获取文件原文件名
        String oldFileName = attachment.getOriginalFilename();
        //定义我们对应上传的文件路径
        //File.separator表示自动读取操作系统上面的目录分隔符
        String path = "F:\\Project\\management\\upload\\";
        //获取文件的扩展名

        String subfix = FilenameUtils.getExtension(oldFileName);
        int fileSize = 500000;//文件限制大小为500K
        if (attachment.getSize() > fileSize) {
            request.setAttribute("uploadFileError", "上传失败，图片太大！");
            map.put("flag", "false");
        } else if (subfix.equalsIgnoreCase("jpg")
                || subfix.equalsIgnoreCase("jpeg")
                || subfix.equalsIgnoreCase("png")
                || subfix.equalsIgnoreCase("gif")) {//判断文件是否符合指定类型
            Random random = new Random();
            String fileName = System.currentTimeMillis() + random.nextInt(10) +"."+ subfix;
            File targetFile = new File(path,fileName);//根据新文件名创建一个新目录
            /*if (!targetFile.exists()) {//不存在则创建
                targetFile.mkdir();
            }*/
            try {
                attachment.transferTo(targetFile);
                image ="upload/" +fileName;

            } catch (IOException e) {
                e.printStackTrace();
                map.put("flag", "false");
            }
            /*****************************文件上传结束********************************************/
//            goods.setImage(image);
            if(goodsService.modifyGoods(gid,gname,tid,price,discount,stock,details,image)>0){
                map.put("flag", "true");
            }

        }
        return JSON.toJSONString(map);
    }

    @RequestMapping("/deleteGoodsById")
    @ResponseBody
    public String deleteGoods( int gid){
        Map<String,String> map=new HashMap<String,String>();
        if(gid>0){
            int result=goodsService.deleteGoods(gid);
            map.put("flag","true");
        }else{
            map.put("flag","false");
        }
        return JSON.toJSONString(map);
    }

    //备选方案
    public User hystrixGet(@PathVariable("id") int id){
        return new User()
                .setUid(id)
                .setUserName("uid=>"+id+"没有对应的信息，null--@Hystrix")
                .setUserPhone("null")
                .setUserEmail("null")
                .setSex(0)
                .setUserPassword("null");
    }

}

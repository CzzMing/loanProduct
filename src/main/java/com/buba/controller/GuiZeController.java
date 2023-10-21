//package com.buba.controller;
//
//import cn.hutool.json.JSONObject;
//import com.buba.pojo.GuiZe;
//import com.buba.service.IGuiZeService;
//import org.apache.ibatis.annotations.Result;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// *
// */
//@RestController
//@RequestMapping("/guiZe")
//@CrossOrigin
//public class GuiZeController {
//
//    @Resource
//    private IGuiZeService guiZeService;
//
//    @RequestMapping("/addGuiZe")
//    public Result addGuiZe(@RequestBody GuiZe guiZe){
//        return guiZeService.addGuiZe(guiZe);
//    }
//
//    @RequestMapping("/getGuiZePage")
//    public Result getGuiZePage(@RequestBody JSONObject json){
//        // todo 接收模糊查询数据和分页数据
//        int pageNow = json.getInt("pageNow");
//        int pageSize = json.getInt("pageSize");
//
//        String gname = json.getStr("gname");
//        String endTime = json.getStr("endTime");
//        return guiZeService.getGuiZePage
//                (pageNow, pageSize, gname, endTime);
//    }
//}

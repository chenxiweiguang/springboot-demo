package com.test.controller;

import com.alibaba.fastjson.JSON;
import com.test.pojo.useInfo;
import com.test.service.useInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class HelloController {
    @Autowired
    private useInfoService useInfoService;
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/a")
    public String index(){
        return "index";
    }

    //Get请求
    @GetMapping
    //@ResponseBody 注释后表示放回的是字符串
    @ResponseBody
    public String queryAll(){
        List<useInfo> userInfoList = useInfoService.queryAll();
        return JSON.toJSONString(userInfoList);
    }

    //使用了RestFull风格
    @GetMapping("/{id}")
    @ResponseBody
    public String query(@PathVariable(value = "id")Integer id){
        System.out.println("-------------------------"+id);
        useInfo useInfo = useInfoService.queryById(id);
        List<useInfo> userInfoList = new ArrayList<>();
        userInfoList.add(useInfo);
        return JSON.toJSONString(userInfoList);
    }
    //post请求
    //@RequestBody 表示接收请求是JSON格式的数据
    @PostMapping
    @ResponseBody
    public String add(@RequestBody useInfo useInfo){
        useInfoService.add(useInfo);
        return "添加OK";
    }

    //Delete请求
    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public String delete(@PathVariable("id")Integer id){
        useInfoService.delete(id);
        return "删除成功";
    }

    //Put请求
    @PutMapping("/{id}")
    @ResponseBody
    public String update(@PathVariable("id")Integer id,
                         @RequestBody useInfo useInfo){
        useInfo.setId(id);
        useInfoService.update(useInfo);
        return "修改成功";
    }

}

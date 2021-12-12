package com.nowcoder.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.StubNotFoundException;

@Controller
//@RequestMapping("/Alpah")
public class AlphaController {
//Get请求
    @RequestMapping(path = "/students",method = RequestMethod.GET)
    @ResponseBody
    public String getStudents(
            @RequestParam(name = "current", required = false,defaultValue = "1") int current,
            @RequestParam(name = "limit", required = false,defaultValue = "1")int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some student";
    }
    @RequestMapping(path = "/alpha/student",method = RequestMethod.POST)
    @ResponseBody
    public String postStudents(String name, int age){
        System.out.println(name + age);
        return "提交成功";
    }
//    响应界面
    @RequestMapping("/teacher")
    public ModelAndView teacher(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("name","张三");
        mv.addObject("age",20);
        mv.setViewName("/demo/view");
        return mv;
    }

}

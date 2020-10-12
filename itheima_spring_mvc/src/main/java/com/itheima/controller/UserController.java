package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.Vo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    //集合
    @RequestMapping(value = "/quick15")
    @ResponseBody //通知springmvc框架 ，改方法不进行view 跳转
    public void save15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }

    //集合
    @RequestMapping(value = "/quick14")
    @ResponseBody //通知springmvc框架 ，改方法不进行view 跳转
    public void save14(Vo vo) throws IOException {
        System.out.println(vo);
    }

    //数组
    @RequestMapping(value = "/quick13")
    @ResponseBody //通知springmvc框架 ，改方法不进行view 跳转
    public void save13(String[] strs) throws IOException {
        System.out.println(Arrays.asList(strs));
    }

    //POJO
    @RequestMapping(value = "/quick12")
    @ResponseBody //通知springmvc框架 ，改方法不进行view 跳转
    public void save12(User user) throws IOException {
        System.out.println(user);
    }

    //普通变量
    @RequestMapping(value = "/quick11")
    @ResponseBody //通知springmvc框架 ，改方法不进行view 跳转
    public void save11(String username,Integer age) throws IOException {
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody //通知springmvc框架 ，改方法不进行view 跳转
    public User save10() throws IOException {
        User user = new User();
        user.setUsername("youfei10");
        user.setAge(27);
        return user;
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody //通知springmvc框架 ，改方法不进行view 跳转
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("youfei");
        user.setAge(27);
        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(user);
        return string;
    }


    @RequestMapping(value = "/quick7")
    @ResponseBody //通知springmvc框架 ，改方法不进行view 跳转
    public String save7() throws IOException {
        return "Hello youfei7";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().println("Hello youfei6");
    }

    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","youfei5");
        return "success";
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        model.addAttribute("username","youfei4");
        return "success";
    }


    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        // 设置视图名称
        modelAndView.setViewName("success");
        // 设置模型数据
        modelAndView.addObject("username","youfei3");
        return modelAndView;
    }


    @RequestMapping(value = "/quick2")
    public ModelAndView save2(){
        // model 封装数据 view 展示数据
        ModelAndView modelAndView = new ModelAndView();
        // 设置视图名称
        modelAndView.setViewName("success");
        // 设置模型数据
        modelAndView.addObject("username","youfei");
        return modelAndView;
    }

    @RequestMapping(value = "/quick",method = RequestMethod.GET,params = {"username"})
    public String save(){
        System.out.println("Controller save running.....");
        return "success";
    }
}

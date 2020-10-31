package com.itheima.controller;

import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.RoleService;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("/list")
    public ModelAndView list(){
        List<User> userList = userService.list();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("userList" , userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/saveUi")
    public ModelAndView saveUi(){
        System.out.println("dasfadsaf");
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = roleService.list();
        modelAndView.addObject("roleList",roleList);
        modelAndView.setViewName("user-add");
        return modelAndView;
    }

    @RequestMapping("/save")
    public String save(User user,long[] roleIds){
        System.out.println("1111dasf");
        userService.save(user,roleIds);
        System.out.println("dasf");
        return "redirect:/user/list";
    }

    @RequestMapping("/del/{userId}")
    public String del(@PathVariable("userId") Long userId){
        userService.del(userId);
        return "redirect:/user/list";
    }

}

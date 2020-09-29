package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    // set方法注入
//    public void setUserDao(UserDao userDao){
//        this.userDao=userDao;
//    }
    //构造方法注入

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }
    public UserServiceImpl() {
    }

    public void save(){
        userDao.save();
    }
//    public void save() {
//        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao)app.getBean("userDao");
//        userDao.save();
//    }
}

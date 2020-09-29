package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

//    <bean id="userService" class="com.itheima.service.impl.UserServiceImpl">
//@Component("userService")
@Service("userService1")
public class UserServiceImpl implements UserService {

    @Value("${jdbc.driver}")
    private String driver;

    //  <property name="userDao" ref="userDao"></property>
//    @Autowired //按照数据类型从spring容器中进行匹配
//    @Qualifier("userDao") //按照id的值，和Autowired一起用
    @Resource(name="userDao") // == Autowired+Qualifier
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println(driver);
        userDao.save();
    }
    @PostConstruct
    public void init(){
        System.out.println("初始化。。。");
    }
    @PreDestroy
    public void destory(){
        System.out.println("销毁中");
    }
}

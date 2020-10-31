package com.itheima.service.impl;

import com.itheima.dao.RoleDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Role;
import com.itheima.domain.User;
import com.itheima.service.UserService;

import java.util.List;

public class UserServiceImpl implements  UserService {

    private UserDao userDao;
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    private RoleDao roleDao;
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<User> list() {
        List<User> userList = userDao.findAll();
        //封装每个user中的roles
        for (User user : userList) {
            Long userId = user.getId();
            //将id作为参数查询对应id的role数据
            List<Role> roles = roleDao.findRolesByUserId(userId);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, long[] roleIds) {
        //向user表里存数据；
        Long userId = userDao.save(user);
        // 向sys_user_role 关系表里存多条数据
        userDao.saveUserRoleRel(userId,roleIds);
    }

    @Override
    public void del(Long userId) {
        //删关系表和原始表
        userDao.delUserRoleRel(userId);
        userDao.delUser(userId);
    }
}

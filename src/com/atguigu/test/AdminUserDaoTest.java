package com.atguigu.test;

import com.atguigu.dao.AdminUserDao;
import com.atguigu.dao.impl.AdminUserDaoImpl;
import com.atguigu.pojo.AdminUser;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author abel
 * @create 2023-09-25 10:30
 */
public class AdminUserDaoTest {

    AdminUserDao adminUserDao = new AdminUserDaoImpl();

    @Test
    public void queryAdminUserByUsername() {
        if (adminUserDao.queryAdminUserByUsername("root") == null ){
            System.out.println("用户名可用！");
        } else {
            System.out.println("用户名已存在！");
        }
    }

    @Test
    public void queryAdminUserByUsernameAndPassword() {
        if ( adminUserDao.queryAdminUserByUsernameAndPassword("root","123456") == null) {
            System.out.println("用户名或密码错误，登录失败");
        } else {
            System.out.println("查询成功");
        }
    }

    @Test
    public void saveAdminUser() {
        System.out.println(adminUserDao.saveAdminUser(new AdminUser(null,"abel123","123456")));
    }
}
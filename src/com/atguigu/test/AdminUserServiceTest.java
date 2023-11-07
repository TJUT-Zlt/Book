package com.atguigu.test;

import com.atguigu.pojo.AdminUser;
import com.atguigu.service.AdminUserService;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.AdminUserServiceImpl;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author abel
 * @create 2023-09-25 10:55
 */
public class AdminUserServiceTest {

    @Test
    public void login() {
        AdminUserService adminUserService = new AdminUserServiceImpl();
        System.out.println(adminUserService.login(new AdminUser(null,"admin","admin")));
    }
}
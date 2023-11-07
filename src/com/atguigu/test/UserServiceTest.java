package com.atguigu.test;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

/**
 * @author abel
 * @create 2023-09-13 14:18
 */
public class UserServiceTest {


    @Test
    public void registUser() {

        UserService userService = new UserServiceImpl();
        userService.registUser(new User(null,"ugly","123456","abc168@163.com"));
    }

    @Test
    public void login() {
        UserService userService = new UserServiceImpl();

        System.out.println(userService.login(new User(null,"admin","admin","null")));
    }

    @Test
    public void existsUsername() {
        UserService userService = new UserServiceImpl();
        if(userService.existsUsername("SAD")){
            System.out.println("用户名已存在！");
        }else {
            System.out.println("用户名可用！");
        }

    }
}
package com.atguigu.web;


import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author abel
 * @create 2023-09-13 14:49
 */
public class LoginServlet extends BaseServlet {


    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser = userService.login(new User(null, username, password, null));
        if(loginUser == null){

            // 把错误信息和回显的表单项信息(用户名称)，保存到Request域中
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);

            req.getRequestDispatcher("/pages/user/adminUser_login.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req,resp);
        }

    }
}

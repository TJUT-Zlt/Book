package com.atguigu.web;

import com.atguigu.pojo.AdminUser;
import com.atguigu.service.AdminUserService;
import com.atguigu.service.impl.AdminUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author abel
 * @create 2023-09-25 10:58
 */
public class AdminUserServlet extends BaseServlet{

    AdminUserService adminUserService =new AdminUserServiceImpl();

    /**
     * 管理员登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        AdminUser loginAdminUser = adminUserService.login(new AdminUser(null, username, password));

        if(loginAdminUser == null){

            // 把错误信息和回显的表单项信息(用户名称)，保存到Request域中
            req.setAttribute("msg","用户名或密码错误！");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/adminUser/adminUser_login.jsp").forward(req,resp);
        }else {

            // 保存用户登录的信息到Session域中
            req.getSession().setAttribute("adminUser", loginAdminUser);

            req.getRequestDispatcher("/pages/manager/manager.jsp").forward(req,resp);
        }

    }

    /**
     *注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1、销毁Session中用户登录的信息（或者销毁Session）
        req.getSession().invalidate();

        //2、重定向到首页（或登录页面）
        resp.sendRedirect(req.getContextPath());
    }

}

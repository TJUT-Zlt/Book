package com.atguigu.service;

import com.atguigu.pojo.AdminUser;
import com.atguigu.pojo.User;

/**
 * @author abel
 * @create 2023-09-25 10:50
 */
public interface AdminUserService {

    /**
     *登录管理员账号
     * @param adminUser
     * @return 如果返回 null，说明登录失败，返回有值，是登录成功
     */
    public AdminUser login(AdminUser adminUser);


}

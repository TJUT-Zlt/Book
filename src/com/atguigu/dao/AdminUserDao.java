package com.atguigu.dao;

import com.atguigu.pojo.AdminUser;

/**
 * @author abel
 * @create 2023-09-25 10:25
 */
public interface AdminUserDao {

    public AdminUser queryAdminUserByUsername(String username);

    public AdminUser queryAdminUserByUsernameAndPassword(String username,String password);

    public int saveAdminUser(AdminUser adminUser);

}

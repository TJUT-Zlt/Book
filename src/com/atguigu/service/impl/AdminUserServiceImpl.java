package com.atguigu.service.impl;

import com.atguigu.dao.AdminUserDao;
import com.atguigu.dao.impl.AdminUserDaoImpl;
import com.atguigu.pojo.AdminUser;
import com.atguigu.service.AdminUserService;

/**
 * @author abel
 * @create 2023-09-25 10:50
 */
public class AdminUserServiceImpl implements AdminUserService {

    AdminUserDao adminUserDao = new AdminUserDaoImpl();

    @Override
    public AdminUser login(AdminUser adminUser) {
        return adminUserDao.queryAdminUserByUsernameAndPassword(adminUser.getUsername(),adminUser.getPassword());
    }

}

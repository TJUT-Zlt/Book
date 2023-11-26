package com.atguigu.dao.impl;

import com.atguigu.dao.AdminUserDao;
import com.atguigu.dao.BaseDao;
import com.atguigu.pojo.AdminUser;

/**
 * @author abel
 * @create 2023-09-25 10:27
 */
public class AdminUserDaoImpl extends BaseDao implements AdminUserDao {

    @Override
    public AdminUser queryAdminUserByUsername(String username) {
        String sql = "select `id`,`username`,`password` from t_user_admin where username = ?";
        return queryForOne(AdminUser.class,sql,username);
    }

    @Override
    public AdminUser queryAdminUserByUsernameAndPassword(String username, String password) {
        String sql = "select `id`,`username`,`password` from t_user_admin where username = ? and password = ?";
        return queryForOne(AdminUser.class,sql,username,password);
    }

    @Override
    public int saveAdminUser(AdminUser adminUser) {
        String sql = "insert into t_user_admin(`username`,`password`) values (?,?)";
        return update(sql,adminUser.getUsername(),adminUser.getPassword());
    }
}

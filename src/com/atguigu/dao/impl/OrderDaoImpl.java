package com.atguigu.dao.impl;

import com.atguigu.dao.OrderDao;
import com.atguigu.pojo.Order;

import java.util.List;

/**
 * @author abel
 * @create 2023-09-18 18:50
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`)values(?,?,?,?,?)";
        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }

    @Override
    public List<Order> queryMyOrders(Integer userId) {
        String sql = "select order_id as orderId,create_time as createTime,price,status,user_id as userId from t_order where user_id=?";
        return queryForList(Order.class,sql,userId);
    }

    @Override
    public List<Order> queryAllOrders() {
        String sql = "select order_id as orderId,create_time as createTime,price,status,user_id as userId from t_order";
        return queryForList(Order.class,sql);
    }

    @Override
    public int changeOrderStatus(int i,String orderId) {
        String sql = "update t_order set status=? where order_id=?";
        return update(sql,i,orderId);
    }
}

package com.atguigu.dao;

import com.atguigu.pojo.Order;

import java.util.List;

/**
 * @author abel
 * @create 2023-09-18 18:49
 */
public interface OrderDao {

    /**
     * 保存订单
     * @param order
     * @return
     */
    int saveOrder(Order order);

    /**
     * 用户操作 查询我的订单
     * @param userId
     * @return
     */
    List<Order> queryMyOrders(Integer userId);

    /**
     * 管理员操作 查询全部订单
     * @return
     */
    List<Order> queryAllOrders();

    /**
     * 管理员和用户操作  订单发货与收货
     * @param i
     * @param orderId
     */
    int changeOrderStatus(int i,String orderId);



}

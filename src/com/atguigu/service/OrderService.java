package com.atguigu.service;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;

import java.util.List;

/**
 * @author abel
 * @create 2023-09-18 19:17
 */
public interface OrderService {

    /**
     * 尝试解决注册用户时user id为null问题
     * @param username
     * @return
     */
    int getUserId(String username);

    /**
     * 创建订单
     * @param cart
     * @param useId
     * @return
     */
    String createOrder(Cart cart,Integer useId);

    /**
     * 用户查询我的订单
     * @param userId
     * @return
     */
    List<Order> myOrder(Integer userId);

    /**
     * 查询订单详情
     * @param OrderId
     * @return
     */
    List<OrderItem> orderDetails(String OrderId);

    /**
     * 管理员查询所有订单
     * @return
     */
    List<Order> allOrder();

    /**
     * 管理员发货
     * @param OrderId
     * @return
     */
    int sendOrder(String OrderId);

    /**
     * 用户收货
     * @param OrderId
     * @return
     */
    int receiveOrder(String OrderId);


}

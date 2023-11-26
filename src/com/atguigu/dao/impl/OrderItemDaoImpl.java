package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.pojo.OrderItem;

import java.util.List;

/**
 * @author abel
 * @create 2023-09-18 18:56
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`)values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderItemsByOrderId(String orderId) {
        String sql = "select name,count,price,total_price as totalPrice from t_order_item where order_id=?";
        return queryForList(OrderItem.class,sql,orderId);
    }
}

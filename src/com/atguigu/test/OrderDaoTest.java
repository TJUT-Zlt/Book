package com.atguigu.test;

import com.atguigu.dao.OrderDao;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.pojo.Order;
import com.atguigu.utils.DateUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * @author abel
 * @create 2023-09-18 18:59
 */
public class OrderDaoTest {

    OrderDao orderDao = new OrderDaoImpl();

    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1234567891123", DateUtils.formateDateTime(new Date()),new BigDecimal(100),0, 1));
    }


    @Test
    public void queryMyOrders() {
        List<Order> orders = orderDao.queryMyOrders(1);
        for(Order order:orders){
            System.out.println(order);
        }
    }

    @Test
    public void queryAllOrders() {
        List<Order> orders = orderDao.queryAllOrders();
        for(Order order:orders){
            System.out.println(order);
        }
    }

    @Test
    public void changeOrderStatus() {
        System.out.println(orderDao.changeOrderStatus(2,"16956897831961"));
    }
}

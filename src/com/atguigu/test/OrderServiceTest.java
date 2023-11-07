package com.atguigu.test;

import com.atguigu.pojo.Cart;
import com.atguigu.pojo.CartItem;
import com.atguigu.pojo.Order;
import com.atguigu.pojo.OrderItem;
import com.atguigu.service.OrderService;
import com.atguigu.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author abel
 * @create 2023-09-18 19:22
 */
public class OrderServiceTest {

    OrderService orderService = new OrderServiceImpl();

    @Test
    public void createOrder() {

        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java从入门到精通", 1, new BigDecimal(1000),new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "数据结构与算法", 1, new BigDecimal(100),new BigDecimal(100)));

        OrderService orderService  = new OrderServiceImpl();

        System.out.println( "订单号是：" + orderService.createOrder(cart, 1) );

    }

    @Test
    public void myOrder() {
        List<Order> orders = orderService.myOrder(1);
        for(Order order:orders){
            System.out.println(order);
        }
    }

    @Test
    public void orderDetails() {
        List<OrderItem> orderItems = orderService.orderDetails("16956489104621");
        for(OrderItem orderItem:orderItems){
            System.out.println(orderItem);
        }
    }

    @Test
    public void allOrder() {
        List<Order> orders = orderService.allOrder();
        for(Order order:orders){
            System.out.println(order);
        }
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("16956903417341");
    }

    @Test
    public void receiveOrder() {
        orderService.receiveOrder("16956903417341");
    }
}
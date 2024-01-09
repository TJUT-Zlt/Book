package com.atguigu.service.impl;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.OrderDao;
import com.atguigu.dao.OrderItemDao;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.BookDaoImpl;
import com.atguigu.dao.impl.OrderDaoImpl;
import com.atguigu.dao.impl.OrderItemDaoImpl;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.*;
import com.atguigu.service.OrderService;
import com.atguigu.utils.DateUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author abel
 * @create 2023-09-18 19:18
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();
    private UserDao userDao  = new UserDaoImpl();

    @Override
    public int getUserId(String username) {
        return userDao.queryUserIdByUsername(username);
    }

    @Override
    public String createOrder(Cart cart, Integer userId) {
        // 订单号===唯一性
        String orderId = System.currentTimeMillis()+""+userId;

        // 创建一个订单对象
        Order order = new Order(orderId, DateUtils.formateDateTime(new Date()),cart.getTotalPrice(), 0,userId);
        // 保存订单
        orderDao.saveOrder(order);
        // 遍历购物车中每一个商品项转换成为订单项保存到数据库
        for (Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()){
            // 获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            // 转换为每一个订单项
            OrderItem orderItem = new OrderItem(null,cartItem.getName(),cartItem.getCount(),cartItem.getPrice(),cartItem.getTotalPrice(), orderId);
            // 保存订单项到数据库
            orderItemDao.saveOrderItem(orderItem);

            // 更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales( book.getSales() + cartItem.getCount() );
            book.setStock( book.getStock() - cartItem.getCount() );
            bookDao.updateBook(book);
        }
        // 清空购物车
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> myOrder(Integer userId) {
        return orderDao.queryMyOrders(userId);
    }

    @Override
    public List<OrderItem> orderDetails(String OrderId) {
        return orderItemDao.queryOrderItemsByOrderId(OrderId);
    }

    @Override
    public List<Order> allOrder() {
        return orderDao.queryAllOrders();
    }

    @Override
    public int sendOrder(String OrderId) {
        return orderDao.changeOrderStatus(1,OrderId);
    }

    @Override
    public int receiveOrder(String OrderId) {
        return orderDao.changeOrderStatus(2,OrderId);
    }
}

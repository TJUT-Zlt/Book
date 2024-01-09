package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 考虑事务的数据库连接--->同一个用户单线程
 * @author abel
 * @create 2023-09-13 8:23
 */
public class JdbcUtils {

    private static DruidDataSource dataSource;

    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();


    static {
        try {
            Properties properties = new Properties();
            //关键 空指针异常
            //InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream("JDBC.properties");
            InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("JDBC.properties");

            properties.load(inputStream);

            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接池中的连接--->数据安全型
     * @return
     */
    public static Connection getConnection(){

        Connection connection = conns.get();
        if(connection == null){
            try {
                connection = dataSource.getConnection(); //从数据库连接池中获取连接
                conns.set(connection); // 保存到 ThreadLocal 对象中，供后面的 jdbc 操作使用
                connection.setAutoCommit(false); // 设置为手动管理事务
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * 提交事务，并关闭释放连接
     */
    public static void commitAndClose(){
        Connection connection = conns.get();
        if (connection != null) { // 如果不等于 null，说明 之前使用过连接，操作过数据库
            try {
                connection.commit(); // 提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close(); // 关闭连接，资源资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 回滚事务，并关闭释放连接
     */
    public static void rollbackAndClose(){
        Connection connection = conns.get();
        if (connection != null) { // 如果不等于 null，说明 之前使用过连接，操作过数据库
            try {
                connection.rollback();//回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close(); // 关闭连接，资源资源
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        // 一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
        conns.remove();
    }

    /**
     * 关闭连接，放回数据库连接池(第一版)
     * @param connection
     */
//    public static void closeConnection(Connection connection){
//        if(connection != null){
//            try {
//                connection.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

}

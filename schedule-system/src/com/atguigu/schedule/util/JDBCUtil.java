package com.atguigu.schedule.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

//https://www.bilibili.com/video/BV1UN411x7xe/?p=96&spm_id_from=333.880.my_history.page.click&vd_source=14551025f000a7403c153e5a0e5f8140
public class JDBCUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    private static DataSource dataSource;

    static{
        Properties properties = new Properties();
        InputStream resourceAsStream = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        try {
            properties.load(resourceAsStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            dataSource  = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection(){
        Connection connection = threadLocal.get();
        if(null == connection){
            try {
                connection = dataSource.getConnection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            threadLocal.set(connection);
        }
        return connection;
    }

    public static void releaseConnection(){
        Connection connection = threadLocal.get();
        if (null != connection){
            threadLocal.remove();
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

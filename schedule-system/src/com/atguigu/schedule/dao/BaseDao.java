package com.atguigu.schedule.dao;

import com.atguigu.schedule.util.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//https://www.bilibili.com/video/BV1UN411x7xe/?p=96&spm_id_from=333.880.my_history.page.click&vd_source=14551025f000a7403c153e5a0e5f8140
public class BaseDao {

    //查询结果是单行单列的一个值
    public <T> T baseQueryObject(Class<T> clazz,String sql,Object ...  args){
        T t = null;
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement  = null;
        ResultSet resultSet = null;
        int rows = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for (int i = 0; i < args.length; i++){
                preparedStatement.setObject(i + 1 , args[i]);
            }

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                t = (T)resultSet.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(null!=resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if ( null != preparedStatement){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            JDBCUtil.releaseConnection();
        }
        return t;
    }

    public <T> List<T> baseQuery(Class clazz, String sql, Object ... args){
        List<T> list = new ArrayList<>();
        Connection connection = JDBCUtil.getConnection();

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int  rows = 0;
        try {
            preparedStatement = connection.prepareStatement(sql);
            for(int i = 0;i<  args.length;i++){
                preparedStatement.setObject(i+1,args[i]);
            }

            resultSet = preparedStatement.executeQuery();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while(resultSet.next()){
                Object obj = clazz.getDeclaredConstructor().newInstance();

                for (  int i = 1; i <= columnCount; i++){
                    String columnName = metaData.getColumnLabel(i);
                    Object value = resultSet.getObject(columnName);
                    if(value.getClass().equals(LocalDateTime.class)){
                        value = Timestamp.valueOf((LocalDateTime) value);
                    }
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(obj,value);
                }
                list.add((T)obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(null!= resultSet){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(null != preparedStatement){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            JDBCUtil.releaseConnection();
        }
        return list ;
    }

    public int baseUpdate(String  sql,Object ... args){
        Connection connection = JDBCUtil.getConnection();
        PreparedStatement preparedStatement =  null;
        int rows = 0;

        try {
            preparedStatement = connection.prepareStatement(sql);
            for ( int i = 0; i < args.length ; i ++){
                preparedStatement.setObject( i +1 , args[i]);
            }
            rows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            if(null != preparedStatement){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            JDBCUtil.releaseConnection();
        }
        return rows;
    }

}

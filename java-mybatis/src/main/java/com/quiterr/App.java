package com.quiterr;

import com.quiterr.datasource.HikariDataSourceFactory;
import com.quiterr.mapper.DeviceMapper;
import com.quiterr.model.Device;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Huangchen on 2017/5/4.
 */
public class App {
    public static void main(String args[]){
        HikariDataSourceFactory hikariDataSourceFactory = new HikariDataSourceFactory();
        DataSource dataSource = hikariDataSourceFactory.getDataSource();
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        Environment environment = new Environment("development", transactionFactory, dataSource);
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(DeviceMapper.class);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        SqlSession session = sqlSessionFactory.openSession();
        System.out.println(oldMethod(session));
        session = sqlSessionFactory.openSession();
        System.out.println(newMethod(session));


    }

    public static Device oldMethod(SqlSession sqlSession){
        try {
            Device device = (Device) sqlSession.selectOne("com.quiterr.mapper.DeviceMapper.findByPosition", "机房");
            return device;
        } finally {
            sqlSession.close();
        }
    }

    public static Device newMethod(SqlSession sqlSession){
        try {
            DeviceMapper deviceMapper = sqlSession.getMapper(DeviceMapper.class);
            Device device = deviceMapper.findByPosition("机房");
            return device;
        } finally {
            sqlSession.close();
        }
    }
}

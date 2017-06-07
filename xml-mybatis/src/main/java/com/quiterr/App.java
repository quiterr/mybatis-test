package com.quiterr;

import com.quiterr.mapper.DeviceMapper;
import com.quiterr.model.Device;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Huangchen on 2017/5/4.
 */
public class App {
    public static void main(String args[]) throws InterruptedException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true); //注意这里不传true的话不会自动提交事务
//        System.out.println(oldMethod(sqlSession));
//        sqlSession = sqlSessionFactory.openSession();
//        System.out.println(newMethod(sqlSession));
        singleInsert(sqlSession);
//        batchInsert(sqlSession);
        Thread.sleep(10000l);
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

    public static void singleInsert(SqlSession sqlSession){
        try {
            DeviceMapper deviceMapper = sqlSession.getMapper(DeviceMapper.class);
            Device device = new Device();
            device.setDeviceId(1);
            device.setType(2);
            device.setPosition("重庆");
            deviceMapper.insertOne(device);
        } finally {
            sqlSession.close();
        }
    }

    public static void batchInsert(SqlSession sqlSession){
        try {
            DeviceMapper deviceMapper = sqlSession.getMapper(DeviceMapper.class);
            List<Device> deviceList = new ArrayList<Device>();
            Device device = new Device();
            device.setDeviceId(1);
            device.setPosition("重庆");
            deviceList.add(device);
            Device device2 = new Device();
            device2.setDeviceId(2);
            device2.setPosition("成都");
            deviceList.add(device2);
            deviceMapper.insertMany(deviceList);
        } finally {
            sqlSession.close();
        }
    }
}

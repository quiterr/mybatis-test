package com.quiterr;

import com.quiterr.model.Device;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Huangchen on 2017/5/4.
 */
public class App {
    public static void main(String args[]){
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            Device device = (Device) sqlSession.selectOne("com.quiterr.mapper.DeviceMapper.findByPosition", "机房");
            System.out.println(device);
        } finally {
            sqlSession.close();
        }
    }
}

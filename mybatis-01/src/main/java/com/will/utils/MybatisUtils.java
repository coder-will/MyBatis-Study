package com.will.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 工具类，这是连接核心配置文件以调用数据库的重要组成部分
 */

public class MybatisUtils {

    private static SqlSessionFactory sqlSessionFactory;

   static {
        try {
            //创建一个mybatis核心配置文件 通过io流读取到这个文件
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            //通过SqlSessionFactoryBuilder类来读取核心配置文件的内容并进行build
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}

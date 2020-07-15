package com.zlk.util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SqlSessionUtil {
    private static SqlSessionFactory sqlSessionFactory;
    private static final String MYBATIS_CONFIG = "mybatis-config.xml";
    static {
        InputStream in = null;
        try {
             in = Resources.getResourceAsStream(MYBATIS_CONFIG);
        } catch (Exception e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
    }
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}


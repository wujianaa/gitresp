package com.zlk.user.test;

import com.zlk.user.entity.Role;
import com.zlk.user.entity.User;
import com.zlk.user.entity.UserRole;
import com.zlk.user.mapper.UserMapper;
import com.zlk.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserTest {
    public static void main(String[] args) throws ParseException {
        testSelectRole();
    }

    private static void testFindUserBtTime() throws ParseException {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Date startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-07-14 00:00:00");
        Date endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-07-15 15:26:23");
        List<User> userList = userMapper.findUserByTime(startTime, endTime);
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }

    private static void testSelectRole() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserRoleById(1);
        for (User user : userList) {
            System.out.print(user.toString()+",");
            System.out.print(user.getUserRole().toString()+",");
            System.out.println(user.getUserRole().getRole().toString());
        }
    }

    private static void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer flag = userMapper.deleteUserById(7);
        sqlSession.commit();
        System.out.println(flag);
    }

    private static void testInsert() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("张三");
        user.setPassword("12345");
        user.setCreateTime(new Date());
        userMapper.saveUser(user);
        sqlSession.commit();
        System.out.println(user.getId());
    }

    private static void testSelectByName() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserByName("2");
        System.out.println(user.toString());
    }

    private static void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.findUserById(1);
        System.out.println(user.toString());
    }

    private static void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserAll();
        for (User user : userList) {
            System.out.println(user.toString());
        }
    }
}

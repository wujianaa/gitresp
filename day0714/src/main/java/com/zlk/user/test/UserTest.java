package com.zlk.user.test;

import com.zlk.user.entity.Role;
import com.zlk.user.entity.User;
import com.zlk.user.entity.UserRole;
import com.zlk.user.mapper.UserMapper;
import com.zlk.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserTest {
    public static void main(String[] args) {
        testSelectRole();
    }

    private static void testSelectRole() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findUserRoleById(1);
        for (User user : userList) {
            System.out.println(user.toString());
            System.out.println(user.getUserRole().getRoleId());
        }
    }

    private static void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer flag = userMapper.deleteUserById(5);
        sqlSession.commit();
        System.out.println(flag);
    }

    private static void testInsert() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setName("张三");
        userMapper.saveUser(user);
        sqlSession.commit();
        //System.out.println(user.getId());
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

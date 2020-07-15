package com.zlk.user.test;

import com.zlk.user.entity.Role;
import com.zlk.user.mapper.RoleMapper;
import com.zlk.user.mapper.UserMapper;
import com.zlk.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleTest {
    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        List<Role> roleList = roleMapper.findRoleById(2);
        for (Role role : roleList) {
            System.out.print(role.toString()+",");
            System.out.print(role.getUserRole()+",");
            System.out.println(role.getUserRole().getUser().toString());
        }
    }
}

package com.zlk.user.mapper;

import com.zlk.user.entity.User;

import java.util.List;

public interface UserMapper {
    /**查询所有用户*/
    List<User>  findUserAll();
    /**根据用户id查询用户*/
    User findUserById(Integer id);
    /**根据用户名查询用户*/
    User findUserByName(String name);
    /**插入用户信息*/
    Integer saveUser(User user);
    /**删除用户信息*/
    Integer deleteUserById(int id);
    /**查询用户id查询角色*/
    List<User>  findUserRoleById(int id);
}

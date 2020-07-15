package com.zlk.user.mapper;

import com.zlk.user.entity.Role;

import java.util.List;

public interface RoleMapper {
    List<Role> findRoleById(int id);
}

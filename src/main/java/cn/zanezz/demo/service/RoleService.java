package cn.zanezz.demo.service;

import cn.zanezz.demo.entity.Roles;

public interface RoleService {
    Integer selectRoleIdByUserId(Integer userId);


    Roles selectRolesByUsername(String username);
}

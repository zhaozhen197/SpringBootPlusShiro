package cn.zanezz.demo.service;

import cn.zanezz.demo.entity.Permission;

import java.util.List;

public interface RolePermissionService {

    List<Permission> selectByRoleId(Integer rid);

    List<String> selectDescriptionByRoleId(Integer roleId);
}

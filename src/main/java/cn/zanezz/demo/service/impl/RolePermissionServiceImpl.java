package cn.zanezz.demo.service.impl;

import cn.zanezz.demo.dao.RolePermissionMapperCustom;
import cn.zanezz.demo.entity.Permission;
import cn.zanezz.demo.service.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    RolePermissionMapperCustom rolePermissionMapperCustom;

    @Override
    public List<Permission> selectByRoleId(Integer rid) {
        return rolePermissionMapperCustom.selectByRoleId(rid);
    }

    @Override
    public List<String> selectDescriptionByRoleId(Integer roleId) {
        return rolePermissionMapperCustom.selectDescriptionByRoleId(roleId);
    }

}

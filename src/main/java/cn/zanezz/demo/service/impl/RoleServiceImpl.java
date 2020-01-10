package cn.zanezz.demo.service.impl;

import cn.zanezz.demo.dao.RolesMapperCustom;
import cn.zanezz.demo.entity.Roles;
import cn.zanezz.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    RolesMapperCustom rolesMapperCustom;

    @Override
    public Integer selectRoleIdByUserId(Integer userId) {
        return rolesMapperCustom.selectRoleIdByUserId(userId);
    }

    @Override
    public Roles selectRolesByUsername(String username) {
        return rolesMapperCustom.selectRolesByUsername(username);
    }

}

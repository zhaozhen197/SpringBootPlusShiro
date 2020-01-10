package cn.zanezz.demo.service.impl;

import cn.zanezz.demo.Base;
import cn.zanezz.demo.service.RoleService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

public class RoleServiceImplTest extends Base {
    @Autowired
    RoleService roleService;


    @Test
    public void selectRoleIdByUsername() {
        System.out.println(roleService.selectRolesByUsername("zane"));
    }

    @Test
    public void selectRolesByUsername() {
    }
}
package cn.zanezz.demo.dao;

import cn.zanezz.demo.entity.Permission;

public interface PermissionMapperCustom {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}
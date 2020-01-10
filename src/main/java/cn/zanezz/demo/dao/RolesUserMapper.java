package cn.zanezz.demo.dao;

import cn.zanezz.demo.entity.RolesUser;

public interface RolesUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolesUser record);

    int insertSelective(RolesUser record);

    RolesUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolesUser record);

    int updateByPrimaryKey(RolesUser record);
}
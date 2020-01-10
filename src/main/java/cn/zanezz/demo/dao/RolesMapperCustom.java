package cn.zanezz.demo.dao;

import cn.zanezz.demo.entity.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;


@Mapper
@Component("rolesMapperCustom")
public interface RolesMapperCustom {
    Integer selectRoleIdByUserId(@Param("uid") Integer uid);

    Roles selectRolesByUsername(@Param("username") String username);
}
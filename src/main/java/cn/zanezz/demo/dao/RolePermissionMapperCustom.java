package cn.zanezz.demo.dao;

import cn.zanezz.demo.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper
@Component("rolePermissionMapperCustom")
public interface RolePermissionMapperCustom {
    List<Permission> selectByRoleId(Integer rid);

    List<String> selectDescriptionByRoleId(Integer rid);

}
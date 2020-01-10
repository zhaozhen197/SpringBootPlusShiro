package cn.zanezz.demo.dao;

import cn.zanezz.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component("userMapperCustom")
public interface UserMapperCustom {
    User getUser(@Param("username") String username, @Param("password") String password);
    User getUserByName(@Param("username") String username);

}
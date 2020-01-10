package cn.zanezz.demo.service;


import cn.zanezz.demo.entity.User;

public interface UserService {

    User getUser(String username, String password);

    User findByUsername(String username);

    Integer getUserRoleId(Integer uid);
    Integer insert(User record);
}

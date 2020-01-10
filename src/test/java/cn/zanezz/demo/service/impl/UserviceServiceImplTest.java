package cn.zanezz.demo.service.impl;

import cn.zanezz.demo.Base;
import cn.zanezz.demo.entity.User;
import cn.zanezz.demo.service.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


class  UserviceServiceImplTest extends Base {

    @Autowired
    UserService userService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getUser() {
    }

    @Test
    void findByUsername() {
        User user = userService.findByUsername("zane");
        System.out.println(user.getEmail());

    }
}
package cn.zanezz.demo.controller;


import cn.zanezz.demo.entity.User;
import cn.zanezz.demo.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/doRegister")
    @ResponseBody
    public String doRegister(User user) {
        Integer res = userService.insert(user);
        return String.valueOf(res);
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    @RequiresPermissions("ice:list")
    public String test() {
        return "111";
    }

}

package cn.zanezz.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {

    @RequestMapping(value = "/unauth")
    @ResponseBody
    public String checkLogin() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("code", "1000000");
        jsonObject.put("msg", "用户未登录");
        return jsonObject.toJSONString();
    }



}
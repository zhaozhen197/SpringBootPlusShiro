package cn.zanezz.demo.service.impl;

import cn.zanezz.demo.common.util.UUIDUtil;
import cn.zanezz.demo.dao.UserMapper;
import cn.zanezz.demo.dao.UserMapperCustom;
import cn.zanezz.demo.entity.User;
import cn.zanezz.demo.service.UserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserviceServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserMapperCustom userMapperCustom;


    @Override
    public User getUser(String username, String password) {
//        return userMapper.getUser(username,password);
        return userMapper.selectByPrimaryKey(21);

    }

    @Override
    public User findByUsername(String username) {
        return userMapperCustom.getUserByName(username);
    }

    @Override
    public Integer getUserRoleId(Integer uid) {
        return null;
    }

    @Override
    public Integer insert(User record) {
        // 生成uuid
        String id = UUIDUtil.getOneUUID();

        // 将用户名作为盐值
        ByteSource salt = ByteSource.Util.bytes(record.getUsername());
        /*
         * MD5加密：
         * 使用SimpleHash类对原始密码进行加密。
         * 第一个参数代表使用MD5方式加密
         * 第二个参数为原始密码
         * 第三个参数为盐值，即用户名
         * 第四个参数为加密次数
         * 最后用toHex()方法将加密后的密码转成String
         * */
        String newPs = new SimpleHash("MD5", record.getPassword(), salt, 2).toHex();
        record.setPassword(newPs);
        User user = userMapperCustom.getUserByName(record.getUsername());
        if (user != null) {
            System.out.println("该用户已存在！");
            return 0;
        }
        return userMapper.insert(record);
    }

}

package cn.zanezz.demo.config;

import cn.zanezz.demo.dao.RolePermissionMapperCustom;
import cn.zanezz.demo.dao.RolesMapperCustom;
import cn.zanezz.demo.entity.Roles;
import cn.zanezz.demo.entity.User;
import cn.zanezz.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyShiroRealm extends AuthorizingRealm {
    @Resource
    private UserService userInfoService;

    @Autowired
    private RolesMapperCustom rolesMapperCustom;

    @Autowired
    private RolePermissionMapperCustom rolePermissionMapperCustom;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//       权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        Roles role = rolesMapperCustom.selectRolesByUsername(user.getUsername());
        List<String> permissionList = rolePermissionMapperCustom.selectDescriptionByRoleId(role.getId());
        authorizationInfo.addStringPermissions(permissionList);

        // 用户的角色集合
//        Set<String> roles = new HashSet<>();
//        roles.add(user.getRoleList().get(0).getRole());
        authorizationInfo.addRole(role.getDescription());

        return authorizationInfo;
    }

    /*主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
//        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        String username = (String) token.getPrincipal();
//        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        User userInfo = userInfoService.findByUsername(username);
        // Subject subject = SecurityUtils.getSubject();
        //Session session = subject.getSession();
        //session.setAttribute("role",userInfo.getRoleList());
//        System.out.println("----->>userInfo="+userInfo);
        if (userInfo == null) {
            return null;
        }
        if (!userInfo.getEnabled()) { //为0时账户冻结
            throw new LockedAccountException();
        }
        String credentials = userInfo.getPassword();
        System.out.println("credentials=" + credentials);
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                credentials, //密码
                credentialsSalt,
                getName()  //realm name
        );
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("USER_SESSION", userInfo);
        return authenticationInfo;
    }
}
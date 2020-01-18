package com.liruilong.hros.config;

import com.liruilong.hros.mapper.MenuMapper;
import com.liruilong.hros.model.Menu;
import com.liruilong.hros.model.Role;
import com.liruilong.hros.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @Description : 权限处理,根据请求,分析需要的角色
 * @Author: Liruilong
 * @Date: 2019/12/24 12:17
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    MenuService menuService;
    //路径比较工具
    AntPathMatcher antPathMatcher = new AntPathMatcher();

    /**
     * @return java.util.Collection<org.springframework.security.access.ConfigAttribute>
     * @Author Liruilong
     * @Description 当前请求需要的角色
     * @Date 18:13 2019/12/24
     * @Param [object]
     **/
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取当前请求路径
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        //获取所有的菜单url路径
        List<Menu> menus = menuService.getAllMenusWithRole();
        for (Menu menu : menus) {
            if (antPathMatcher.match(menu.getUrl(), requestUrl)) {
                //拥有当前菜单权限的角色
                List<Role> roles = menu.getRoles();
                String[] strings = new String[roles.size()];
                for (int i = 0; i < roles.size(); i++) {
                    strings[i] = roles.get(i).getName();
                }
                return SecurityConfig.createList(strings);
            }
        }
        // 没匹配上登录可以访问
        return SecurityConfig.createList("ROLE_LOGIN");

    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}

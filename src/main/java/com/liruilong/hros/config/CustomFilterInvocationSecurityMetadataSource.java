package com.liruilong.hros.config;
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
import java.util.logging.Logger;
/**
 * @Description : 权限处理,根据请求,分析需要的角色,该类的主要功能就是通过当前的请求地址，获取该地址需要的用户角色
 * @Author: Liruilong
 * @Date: 2019/12/24 12:17
 */
@Component
public class CustomFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
    @Autowired
    MenuService menuService;
    //路径比较工具
    AntPathMatcher antPathMatcher = new AntPathMatcher();
    Logger logger = Logger.getLogger("com.liruilong.hros.config.ustomFilterInvocationSecurityMetadataSource");
    /**
     * @return java.util.Collection<org.springframework.security.access.ConfigAttribute> * 返回值是 Collection<ConfigAttribute>，表示当前请求 URL 所需的角色。
     * @Author Liruilong
     * @Description 当前请求需要的角色,该方法的参数是一个 FilterInvocation， 开发者可以从 Filterlnvocation 中提取出当前请求的 URL，
     * @Date 18:13 2019/12/24
     * @Param [object]
     **/
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //获取当前请求路径
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        logger.warning(requestUrl);
        //获取所有的菜单url路径
        List<Menu> menus = menuService.getAllMenusWithRole();
        // AntPathMatcher，主要用来实现 ant 风格的 URL 匹配。
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
        // 没匹配上的资源都是登录，或者为公共资源
        return SecurityConfig.createList("ROLE_LOGIN");
    }
    /**
     * @Author Liruilong
     * @Description 用来返回所有定义好的权限资源， Spring Security 在启动时会校验 相关配置是否正确，如果不需要校验，那么该方法直接返回 null 即可。
     * @Date 18:06 2020/2/13
     * @Param []
     * @return java.util.Collection<org.springframework.security.access.ConfigAttribute>
     **/

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }
    /**
     * @Author Liruilong
     * @Description 返回类对象是否支持校验。
     * @Date 18:06 2020/2/13
     * @Param [clazz]
     * @return boolean
     **/

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}

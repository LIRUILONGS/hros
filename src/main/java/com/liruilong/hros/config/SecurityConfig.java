package com.liruilong.hros.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liruilong.hros.filter.VerifyCodeFilter;
import com.liruilong.hros.model.Hr;
import com.liruilong.hros.model.RespBean;
import com.liruilong.hros.service.HrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.PrintWriter;

/**
 * @Description :

 * @Date: 2019/12/18 19:11
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    HrService hrService;
    @Autowired
    CustomFilterInvocationSecurityMetadataSource customFilterInvocationSecurityMetadataSource;
    @Autowired
    CustomUrlDecisionManager customUrlDecisionManager;
    @Autowired
    VerifyCodeFilter verifyCodeFilter ;
    @Autowired
    MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(hrService);
    }

    /**
     * @return void
     * @Author liruilong
     * @Description 放行的请求路径
     * @Date 19:25 2020/2/7
     * @Param [web]
     **/

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/auth/code","/login","/css/**","/js/**", "/index.html", "/img/**", "/fonts/**","/favicon.ico");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterBefore(verifyCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                //.anyRequest().authenticated()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
                        object.setAccessDecisionManager(customUrlDecisionManager);
                        object.setSecurityMetadataSource(customFilterInvocationSecurityMetadataSource);
                        return object;
                    }
                })
                .and().formLogin().usernameParameter("username").passwordParameter("password").loginProcessingUrl("/doLogin")
                .loginPage("/login")
                //登录成功回调
                .successHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    Hr hr = (Hr) authentication.getPrincipal();
                    //密码不回传
                    hr.setPassword(null);
                    RespBean ok = RespBean.ok("登录成功！", hr);
                    //将hr转化为Sting
                    String s = new ObjectMapper().writeValueAsString(ok);
                    out.write(s);
                    out.flush();
                    out.close();
                })
                //登失败回调
                .failureHandler(myAuthenticationFailureHandler)
                //相关的接口直接返回
                .permitAll()
                .and()
                .logout()
                //注销登录
                // .logoutSuccessUrl("")
                .logoutSuccessHandler((httpServletRequest, httpServletResponse, authentication) -> {
                    httpServletResponse.setContentType("application/json;charset=utf-8");
                    PrintWriter out = httpServletResponse.getWriter();
                    out.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功!")));
                    out.flush();
                    out.close();
                })
                .permitAll()
                .and()
                .csrf().disable().exceptionHandling()
                //没有认证时，在这里处理结果，不要重定向
                .authenticationEntryPoint((req, resp, authException) -> {
                    resp.setContentType("application/json;charset=utf-8");
                    resp.setStatus(401);
                    PrintWriter out = resp.getWriter();
                    RespBean respBean = RespBean.error("访问失败!");
                    if (authException instanceof InsufficientAuthenticationException) {
                        respBean.setMsg("请求失败，请联系管理员!");
                    }
                    out.write(new ObjectMapper().writeValueAsString(respBean));
                    out.flush();
                    out.close();
                });
    }
}
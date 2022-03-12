package com.pangpan.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author pangpan
 * @date 2022-01-16
 */
@Configuration
public class MyWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    MyAccessDeniedHandler myAccessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //和表单的相关配置
        http.formLogin()
                //.loginPage("/home")//登陆页面
                .loginProcessingUrl("/level1")//成功后的页面
                .usernameParameter("username")//自定义username的key
                .passwordParameter("password");//自定义password的key

        http.authorizeRequests()
                .antMatchers("/home").permitAll()///home的可以通行不需要验证
                .antMatchers("/js/**").permitAll()//放行所有的js下的静态文件
                .antMatchers("/abc").denyAll()//报权限不足
                .anyRequest().authenticated();//其他的需要授权

        //身份异常
//        http.exceptionHandling().authenticationEntryPoint();
        //权限异常处理
        http.exceptionHandling()
                .accessDeniedHandler(myAccessDeniedHandler);//处理异步的权限异常返回json串
//        http.exceptionHandling().accessDeniedPage("/erro");//处理同步的时候，返回界面（controller的路径）

        http.csrf().disable();
    }
}

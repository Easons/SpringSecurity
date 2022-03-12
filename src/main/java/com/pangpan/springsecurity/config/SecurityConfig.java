package com.pangpan.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author pangpan
 * @date 2021-11-26
 */
@EnableWebSecurity
public class SecurityConfig {//extends WebSecurityConfigurerAdapter {

    @Bean
    protected PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }

//    //链式编程：责任链模式
//
//    /**
//     * 授权
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //首页所有人可以访问，功能页只有对应权限的人才能访问
////        super.configure(http);
//
//        //请求授权的规则
//        http.authorizeRequests()
//                .antMatchers(".").permitAll()
//                .antMatchers("/level1/**").hasRole("vip1")
//                .antMatchers("/level2/**").hasRole("vip2")
//                .antMatchers("/level3/**").hasRole("vip3");
//
//        //没有开启到登陆页面，自定义用户名和密码的取值key
//        http.formLogin().loginPage("/home")
//        .loginProcessingUrl("/home")
//        .usernameParameter("username")
//        .passwordParameter("password");
//
//        //注销
//        http.logout()
//        .deleteCookies("remove").invalidateHttpSession(true)
//                .logoutUrl("/home").logoutSuccessUrl("/home");
//
//        //记住我功能：往客户端放了个cookie，默认保存2周
//        http.rememberMe().rememberMeParameter("rememberme");
//    }
//
//    /**
//     * 认证
//     * 2.1.X springboot版本之后会报密码这个错误：There is no PasswordEncoder mapped for the id "null"
//     * @param auth
//     * @throws Exception
//     */
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        super.configure(auth);
//
//        //不从数据库，从内存中定义用户
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("pangpan").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2")
//                .and()
//                .withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3");
//
//
////        auth.jdbcAuthentication().dataSource()
//    }
}

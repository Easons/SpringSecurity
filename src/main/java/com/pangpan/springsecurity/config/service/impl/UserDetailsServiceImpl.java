package com.pangpan.springsecurity.config.service.impl;

import com.pangpan.springsecurity.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author pangpan
 * @date 2022-01-16
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

//        if(!userName.equals("admin")){
//            throw new UsernameNotFoundException("不存在");
//        }
//
//        //从数据库中获取密码
//        String password = "pwd";
//        String encodePassword = passwordEncoder.encode(password);
//        //AuthorityUtils：是权限，一般是从数据库中查询到，然后放入
//        UserDetails userDetails = new User(userName, encodePassword,
//                AuthorityUtils.commaSeparatedStringToAuthorityList("admin1,admin2"));


        com.pangpan.springsecurity.entity.User user = userMapper.selectByUserName(userName);
        if(user == null){
            throw new UsernameNotFoundException("不存在");
        }

        UserDetails userDetails = new User(userName, user.getPassword(),
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin1,admin2"));

                //##需要有密码解析器，不然会报错
        return userDetails;
    }
}

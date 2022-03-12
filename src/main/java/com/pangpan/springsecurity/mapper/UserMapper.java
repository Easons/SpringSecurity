package com.pangpan.springsecurity.mapper;

import com.pangpan.springsecurity.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author pangpan
 * @date 2022-01-16
 */
@Mapper
public interface UserMapper {

    public User selectByUserName(String username);
}

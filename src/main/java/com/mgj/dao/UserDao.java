package com.mgj.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.mgj.entity.User;

@Mapper
public interface UserDao {

	@Select("select * from user where username=#{username} and password = #{password}")
	User getUser(User user);

}

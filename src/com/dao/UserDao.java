package com.dao;

import com.pojo.UserPo;;
/**
 * 用户登陆接口
 * @author zhouchao
 *
 */
public interface UserDao {
	
	public UserPo selectLogin(UserPo user);
	
}

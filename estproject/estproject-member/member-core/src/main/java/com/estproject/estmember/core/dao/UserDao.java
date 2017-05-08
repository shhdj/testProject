package com.estproject.estmember.core.dao;


import com.estproject.estmember.common.domain.User;

public interface UserDao {

	User queryUserById(Long id);
}

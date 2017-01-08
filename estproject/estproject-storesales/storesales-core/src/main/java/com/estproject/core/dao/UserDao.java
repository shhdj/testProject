package com.estproject.core.dao;

import com.estproject.common.domain.UserVO;

public interface UserDao {

	UserVO queryUserById(Long id);
}

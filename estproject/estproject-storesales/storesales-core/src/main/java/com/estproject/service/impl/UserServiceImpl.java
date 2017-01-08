package com.estproject.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estproject.common.domain.UserVO;
import com.estproject.core.dao.UserDao;
import com.estproject.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
//
//	@Autowired
//	private UserDao userDao;
	
	public UserVO queryUser(Long id) {
//		UserVO vo = userDao.queryUserById(id);
//		return vo;
		return new UserVO();
	}

}

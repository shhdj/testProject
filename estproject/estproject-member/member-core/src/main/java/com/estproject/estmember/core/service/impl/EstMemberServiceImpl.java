/*
 * Copyright 2016  Tech. Ltd. All rights reserved.

 */
package com.estproject.estmember.core.service.impl;

import com.estproject.estmember.common.domain.User;
import com.estproject.estmember.core.dao.UserDao;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;

import com.estproject.estmember.core.service.EstMemberService;

import javax.annotation.Resource;

/**
 * @author: 谭锡标
 * @since: 2016年6月12日下午2:34:52
 * @version: 1.0
 */
@Service("estMemberService")
public class EstMemberServiceImpl implements EstMemberService {

	@Resource
	private UserDao userDao;

	public void queryById(Long id) {
		userDao.queryUserById(id);
	}

	public User queryByUserId(Long id) {
		User u =userDao.queryUserById(id);
		return u;
	}
}

/*
 * Copyright 2016  Tech. Ltd. All rights reserved.

 */
package com.estproject.storesales.core.member.ao;

import com.estproject.estmember.common.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estproject.estmember.common.hessian.EstMemberServiceRemote;
import com.estproject.framework.base.AbstractBaseModule;

/**
 * @author: 谭锡标
 * @since: 2016年6月13日上午9:13:19
 * @version: 1.0
 */
@Service
public class EstMemberAO extends AbstractBaseModule {

	@Autowired
	private EstMemberServiceRemote estMemberService;
	
	public User queryMemberById(Long id){
		User u = estMemberService.queryByUserId(id);
		return  u ;
	}
}

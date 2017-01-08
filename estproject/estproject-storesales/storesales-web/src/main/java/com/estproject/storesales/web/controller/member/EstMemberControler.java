/*
 * Copyright 2016  Tech. Ltd. All rights reserved.

 */
package com.estproject.storesales.web.controller.member;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.estproject.storesales.core.member.ao.EstMemberAO;

/**
 * @author: 谭锡标
 * @since: 2016年6月13日上午8:56:28
 * @version: 1.0
 */
@RequestMapping("/estMember")
@Controller
public class EstMemberControler {

	@Autowired
	private EstMemberAO estMemberAO;
	
	@RequestMapping(value="queryMemberById",method = RequestMethod.POST)
	public String queryMemberById(String id){
		if(StringUtils.isNotBlank(id)){
			Long memid = Long.valueOf(id);
			estMemberAO.queryMemberById(memid);
		}
		
		return "member/list";
	}
	
	
}

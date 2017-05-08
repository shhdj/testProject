/*
 * Copyright 2016  Tech. Ltd. All rights reserved.

 */
package com.estproject.storesales.web.controller.member;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.estproject.storesales.core.member.ao.EstMemberAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	@RequestMapping(value="queryMemberById",method = {RequestMethod.GET,RequestMethod.POST})
	public String queryMemberById(String id, HttpServletRequest request, HttpServletResponse response){
		if(StringUtils.isNotBlank(id)&& NumberUtils.isDigits(id)){
			Long memid = Long.valueOf(id);
			estMemberAO.queryMemberById(memid);
		}
		
		return "member/list";
	}
	
	
}

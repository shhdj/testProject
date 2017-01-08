/*
 * Copyright 2016  Tech. Ltd. All rights reserved.

 */
package com.estproject.estmember.common.domain;

import java.io.Serializable;

/**
 * @author: 谭锡标
 * @since: 2016年6月12日下午3:36:33
 * @version: 1.0
 */
public class MemberVO implements Serializable {

	/**
	 * @Fields serialVersionUID: 
	 */
	private static final long serialVersionUID = -1496707800452796671L;

	private Long id;
	
	private String userName;
	
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}

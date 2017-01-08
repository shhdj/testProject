/*
 * Copyright (c) 2014-2020 Etong Tech. Ltd. All Rights Reserved.
 * Distributed with this file and available online at
 * http://www.etong.com/
 */
package com.estproject.framework.web.security;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * <p>
 * 商品服务hessian权限客户端类，对远程服务的用户名和密码进行赋值
 * </p>
 * 
 * @author: 谭锡标
 * @see:
 * @since: 2014年11月27日
 */
@Service("authHessianProxyFactory")
public class AuthHessianProxyFactory extends HessianProxyFactory {
	/**
	 * 消息管理对象
	 */
	@Autowired
	private MessageSource messageSource;
	
	 /**
	 *获取消息管理对象
	 * @return messageSource 消息管理对象 
	 */
	
	public MessageSource getMessageSource() {
		return messageSource;
	}
	/**
	 * 设置消息管理对象 
	 *@param messageSource 消息管理对象
	 */
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	@Override
	 public String getBasicAuth(){
		 setBasicAuthentication();
		 return super.getBasicAuth();
	 }
	/**
	 * 设置基本安全验证
	 */
	private void setBasicAuthentication(){
		setUser(messageSource.getMessage("hessian.proxy.auth.username", null, Locale.getDefault()));
		setPassword(messageSource.getMessage("hession.proxy.auth.password", null, Locale.getDefault()));		
	}
}

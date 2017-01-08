/*
 * Copyright (c) 2014-2020 Etong Tech. Ltd. All Rights Reserved.
 * Distributed with this file and available online at
 * http://www.etong.com/
 */
package com.estproject.framework.web.security;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.remoting.caucho.HessianServiceExporter;

/**
 * 
 * Hessian Service Exporter安全设置访问类
 * @author: 谭锡标
 * @see:
 * @since: 2014年11月27日
 */
public class AuthHessianServiceExporter extends HessianServiceExporter {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private String credentialsCharset = "UTF-8";
	
	/**
	 * 消息管理对象
	 */
	@Autowired
	private MessageSource messageSource;

	
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		String authorization = request.getHeader("Authorization");
		String requestIP = request.getRemoteHost();
		
		if(StringUtils.isBlank(authorization) || !authorization.startsWith("Basic ")){
			logger.error("来自" + requestIP + "的非法请求！没有验证信息.");
			throw new SecurityException(messageSource.getMessage("hessian.exporter.auth.failure", null, Locale.getDefault()));
		}
		
		String[] tokens = extractAndDecodeHeader(authorization, request);
		
		String username = tokens[0];
		String password = tokens[1];
		
		if (StringUtils.isBlank(username)
				|| !username.equals(messageSource.getMessage("hessian.exporter.auth.username", null, Locale.getDefault()))) {
			logger.error("来自" + requestIP + "的非法请求！用户名为空或用户名不正确.");

			throw new SecurityException(messageSource.getMessage("hessian.exporter.auth.failure", null, Locale.getDefault()));
		} else {
			if (StringUtils.isBlank(password)
					|| !password.equals(messageSource.getMessage("hessian.exporter.auth.password", null, Locale.getDefault()))) {
				logger.error("来自" + requestIP + "的非法请求！密码为空或用密码错误.");

				throw new SecurityException(messageSource.getMessage("hessian.exporter.auth.failure", null, Locale.getDefault()));
			} else {
				super.handleRequest(request, response);
			}
		}
	}
	
	
	/**
     * Decodes the header into a username and password.
     *
     * @throws IOException if the Basic header is not present or is not valid Base64
     */
    private String[] extractAndDecodeHeader(String header, HttpServletRequest request) throws IOException {
        byte[] base64Token = header.substring(6).getBytes(credentialsCharset);
        byte[] decoded;
        try {
        	decoded = Base64.decodeBase64(base64Token);
        } catch (IllegalArgumentException e) {
            throw new IOException("Failed to decode basic authentication token");
        }
 
        String token = new String(decoded, credentialsCharset);
 
        int delim = token.indexOf(":");
 
        if (delim == -1) {
            throw new IOException("Invalid basic authentication token");
        }
        return new String[] {token.substring(0, delim), token.substring(delim + 1)};
    }
    
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
}

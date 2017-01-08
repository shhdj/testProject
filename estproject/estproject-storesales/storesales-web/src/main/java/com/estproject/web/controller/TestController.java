package com.estproject.web.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.estproject.service.IUserService;

@Controller
public class TestController {

	@Autowired
	private IUserService userService; 

	@RequestMapping("/queryUser")
	public void queryUser(Long id,HttpServletRequest request,HttpServletResponse response){

		userService.queryUser(id);
		
	}
}

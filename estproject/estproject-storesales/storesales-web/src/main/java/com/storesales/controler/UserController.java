package com.storesales.controler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
/**
*@author 作者：
*@version 创建时间：2015年11月23日 下午10:41:20
*类说明：
*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.storesales.query.model.ItemInfoQuery;
import com.storesales.model.User;
import com.storesales.service.IUserJdbcService;
import com.storesales.tools.ResponseUtil;
@Controller
public class UserController {

	@Autowired
	private IUserJdbcService userJdbcService;
	
	@RequestMapping("/user/loginView")
	public String loginView(){
		return "login";
	}
	@RequestMapping("/user/registerView")
	public String registerView(){
		return "register";
	}
	
	@RequestMapping("/user/login")
	public ModelAndView login(User user){
		ModelAndView mav = new ModelAndView();
		User u = userJdbcService.loginCheck(user);
		if(null == u){
			mav.setViewName("login");
			mav.addObject("errorMsg", "用户名或密码有误");
			return mav;
		}
		else{
			mav.setViewName("success");
			mav.addObject("user", u);
			return mav;
		}
	}
	
	
	@RequestMapping("/test")
	public void test(HttpServletRequest request,HttpServletResponse response,@RequestBody String requestBody){
		System.out.println(requestBody);
		Map paraMap = new HashMap();
		paraMap.put("saveFilePathName", "tttttttttttttttt");
		Gson gson = new GsonBuilder().enableComplexMapKeySerialization().create();
		ResponseUtil.write(response, gson.toJson(paraMap));

	}
	@RequestMapping("/testjdbc")
	public void testjdbc(HttpServletRequest request,HttpServletResponse response){

		List<ItemInfoQuery> iilist = userJdbcService.getResultList(ItemInfoQuery.class,
				"select b.item_no,b.item_subno,b.item_name from bi_t_item_info b");
		iilist.toArray();
	}
	
	
}

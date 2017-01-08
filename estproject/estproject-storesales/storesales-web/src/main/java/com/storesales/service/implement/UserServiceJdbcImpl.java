package com.storesales.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storesales.dao.IUserDao;
import com.storesales.model.User;
import com.storesales.service.IUserJdbcService;

/**
*@author ���ߣ�
*@version ����ʱ�䣺2015��11��25�� ����10:49:35
*��˵����
*/
@Service
public class UserServiceJdbcImpl implements IUserJdbcService {

	@Autowired
	private IUserDao userDAO;
	
	public boolean register(User user) {
		User u = userDAO.findUserByUserName(user.getUserName());
		if(u.getId()==0){
			userDAO.register(user);
			return true;
		}else{
			System.out.println("id="+u.getId()+",  userName="+u.getUserName()+", password="+u.getPassword());
			return false;
		}
	}

	public User loginCheck(User user) {
		User u = userDAO.findUserByUserName(user.getUserName());
		System.out.println("id="+u.getId()+",  userName="+u.getUserName()+", password="+u.getPassword());
		if(user.getPassword().equals(u.getPassword())){
			return user;
		}else{
			return null;
		}
	}
	
	public <T> List<T> getResultList(Class<T> clz,String sql){
		return userDAO.getResultList(clz, sql);
	}

}

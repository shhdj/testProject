package com.storesales.service;

import java.util.List;

import com.storesales.model.User;


public interface IUserJdbcService {

	public boolean register(User user);
	public User loginCheck(User user);
	
	public <T> List<T> getResultList(Class<T> clz,String sql);
}

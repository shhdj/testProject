package com.storesales.dao;

import java.util.List;

import com.storesales.model.User;


public interface IUserDao {

	public void register(User user);
	public User findUserByUserName(final String name);
	public <T> List<T> getResultList(Class<T> clz,String sql);
}

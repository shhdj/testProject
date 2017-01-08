package com.estproject.service;


import com.estproject.common.domain.UserVO;


public interface IUserService {

	UserVO queryUser(Long id);
}

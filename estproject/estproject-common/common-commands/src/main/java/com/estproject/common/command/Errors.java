package com.estproject.common.command;

import java.io.Serializable;
import java.util.Map;


/**
 * 
 * <p>错误返回对象</p> 
 *
 * @author: 谭锡标
 * @since: 2016年6月8日上午11:20:38
 * @version: 1.0
 */
public interface Errors extends Serializable {

	/**
	 * 
	 * <p>返回结果是否成功</p> 
	 * @return 
	 * @throws
	 */
	boolean isSuccess();
	
	
	/**
	 * 
	 * <p>设置操作</p> 
	 * @param flag 
	 * @throws
	 */
	void setSuccess(boolean flag);
	
	/**
	 * 设置错误，包含错误码和提示信息
	 * <p></p> 
	 * @param code
	 * @param msg 
	 * @throws
	 */
	void setError(String code,String msg);
	
	
	/**
	 * 根据错误码获取提示信息
	 * <p></p> 
	 * @param code
	 * @return 
	 * @throws
	 */
	String getError(String code);
	
	/**
	 * 获取所有错误列表
	 * @return 
	 * @throws
	 */
	Map<String, String> getErrorMap();
}

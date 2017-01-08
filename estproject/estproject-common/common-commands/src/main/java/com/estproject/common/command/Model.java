package com.estproject.common.command;

import java.io.Serializable;
import java.util.Map;

/**
 * 返回结果接口
 * @author: 谭锡标
 * @since: 2016年6月8日上午11:50:53
 * @version: 1.0
 */
public interface Model extends Serializable {

	/**
	 * 获取所有模型
	 * @return 
	 * @throws
	 */
	Map<String,Object> getModels();
	
	/**
	 * 获取指定模型
	 * @param key
	 * @return 
	 * @throws
	 */
	<T> Object getModel(String key);
	
	/**
	 * 获取默认模型
	 * @return 
	 * @throws
	 */
	<T> Object getModel();
	
	/**
	 * 设定默认模型
	 * @param model 
	 * @throws
	 */
	void setModel(Object model);
	
	/**
	 * 设置模型
	 * @param key
	 * @param model 
	 * @throws
	 */
	void setModel(String key,Object model);
}

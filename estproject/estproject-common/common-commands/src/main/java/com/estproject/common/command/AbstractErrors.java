package com.estproject.common.command;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象公共错误处理
 * @author: 谭锡标
 * @since: 2016年6月8日下午1:52:48
 * @version: 1.0
 */
public abstract class AbstractErrors implements Errors {

	/**
	 * @Fields serialVersionUID: 
	 */
	private static final long serialVersionUID = 2814632609973395221L;

	private boolean success = true;
	
	private Map<String,String> errorMap = new HashMap<String, String>();
	
	private String errorMsg;
	
	
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean flag) {
		success = false;
	}

	public void setError(String code, String msg) {
		if(this.isSuccess()){
			this.setSuccess(false);
		}
		this.errorMap.put(code, msg);
	}

	public String getError(String code) {
		return this.errorMap.get(code);
	}

	public Map<String, String> getErrorMap() {
		return this.errorMap;
	}

}

package com.estproject.estmember.common.hessian;


import com.estproject.estmember.common.domain.User;
import com.estproject.framework.base.service.EstProjectServiceBase;

/**
 * 
 * <p>会员服务接口</p> 
 *
 * @author: 谭锡标
 * @since: 2016年6月8日上午9:57:42
 * @version: 1.0
 */
public interface EstMemberServiceRemote extends EstProjectServiceBase {

	User queryByUserId(Long Id);
}

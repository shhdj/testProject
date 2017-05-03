package com.estproject.service.goods.Dispatch;

import java.lang.annotation.Annotation;
/***
 * 任务调度控制接口
 * @author  YZH
 * @version 1.0
 * @date 2016年4月14日
 */
public interface IDispatch<A extends Annotation,B,C>{
	/***
	 * 获取调度标识值
	 * @param annotation
	 * @return
	 */
	B getKey(A annotation);
    
	/***
	 * 获取任务值
	 * @param classObject
	 * @param annotation
	 * @return
	 */
    C getValue(Object classObject, A annotation);
}

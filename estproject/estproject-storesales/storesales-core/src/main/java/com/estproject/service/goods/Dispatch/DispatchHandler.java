package com.estproject.service.goods.Dispatch;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import com.estproject.service.goods.annotional.DispatchAnnotation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

/***
 * 任务调度控制器
 * @author  YZH
 * @version 1.0
 * @date 2016年4月14日
 */
@Component
public class DispatchHandler implements InitializingBean, ApplicationContextAware{
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 上下文对象
	private ApplicationContext applicationContext;

	


	@SuppressWarnings({ "unused", "unchecked" })
	public void afterPropertiesSet() throws Exception {
		try {
			final Map<String, Object> annotations = applicationContext.getBeansWithAnnotation(DispatchAnnotation.class);
			if (!CollectionUtils.isEmpty(annotations)) {
				for (Map.Entry<String, Object> annotation : annotations.entrySet()) {
					if (ObjectUtils.isEmpty(annotation) || ObjectUtils.isEmpty(annotation.getValue())) {
						continue;
					}
					Object dispatchImpl = annotation.getValue();
					DispatchAnnotation walletAnnotation = dispatchImpl.getClass().getAnnotation(DispatchAnnotation.class);
					if (dispatchImpl instanceof IDispatch) {
						IDispatch<Annotation, Object, Object> annotationHandler = (IDispatch<Annotation, Object, Object>) dispatchImpl;
						Type[] genericInterfaces = annotationHandler.getClass().getGenericInterfaces();
						if (null != genericInterfaces && genericInterfaces.length > 0) {
							Type[] actualTypeArgument = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
							if (null != actualTypeArgument && actualTypeArgument.length > 0) {
								DispatchInit.getInstance().init(applicationContext,annotationHandler, actualTypeArgument);
							}
						}
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		
	}
	

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

}

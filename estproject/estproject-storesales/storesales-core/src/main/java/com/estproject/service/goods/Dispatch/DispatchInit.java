package com.estproject.service.goods.Dispatch;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;


/***
 * 策略加载器
 * @author  YZH
 * @version 1.0
 * @date 2016年4月14日
 */
final class DispatchInit {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	private final static DispatchInit _this = new DispatchInit();
	private final static Map<String, Map<Object, Object>> _data = new HashMap<String, Map<Object, Object>>();
	private DispatchInit(){}
	public static DispatchInit getInstance(){
		   return _this;
	}
	
	public Map<String, Map<Object, Object>> getContainer(){
		return _data;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void init(ApplicationContext applicationContext,IDispatch<Annotation, Object, Object> annotationHandler,
			Type[] actualTypeArgument){
		try {
			Type param_A = actualTypeArgument[0];
			Class<? extends Annotation> annotationType = ((Class) param_A);
			if (_data.containsKey(annotationType.getName())) {
				throw new ArrayStoreException(String.format("注解加载异常：存在多个注册为【%s】类型注解的类!", annotationType.getName()));
			}
			Map<Object, Object> _cache = new HashMap<Object, Object>();
			final Map<String, Object> custom_annotations = applicationContext.getBeansWithAnnotation(annotationType);
			if (!CollectionUtils.isEmpty(custom_annotations)) {
				for (Map.Entry<String, Object> annotation : custom_annotations.entrySet()) {
					Object annotationImpl = annotation.getValue();
					final Class<? extends Object> annotationClass = annotationImpl.getClass();
					Annotation custom_annotation = annotationClass.getAnnotation(annotationType);
					Object key = annotationHandler.getKey(custom_annotation);
					Object value = annotationHandler.getValue(annotationImpl, custom_annotation);
					if (!ObjectUtils.isEmpty(key)) {
						if (_cache.containsKey(key)) {
							throw new ArrayStoreException(String.format("注解加载异常：【%s】对象存在多个标记为【%s】的通道!",
									annotationType.getName(), key.getClass().getName()));
						}
						_cache.put(key, value);
					}
					if (ObjectUtils.isEmpty(value)) {
						logger.warn("注解加载WARN：【%s】对象标识值为【key.getClass().getName()】的对象值为空！");
					}
				}

			}
			_data.put(annotationType.getName(), _cache);
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
	}
}

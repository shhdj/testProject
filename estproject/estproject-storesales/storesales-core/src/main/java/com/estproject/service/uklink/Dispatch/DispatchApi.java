package com.estproject.service.uklink.Dispatch;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.etong.framework.util.CollectionUtils;

/***
 * 分发Api
 * @author  YZH
 * @version 1.0
 * @date 2016年4月14日
 */
public final class DispatchApi {
   private final static DispatchApi _this = new DispatchApi();
   private DispatchApi(){}
   public static DispatchApi getInstance(){
	   return _this;
   }
   
   public Map<String, Map<Object, Object>> getContainer(){
		return DispatchInit.getInstance().getContainer();
	}
   
   /***
    * 获取处理策略
    * @param annotationType
    * @param key
    * @return
    */
   @SuppressWarnings("unchecked")
   public <T> T getImpl(Class<? extends Annotation> annotationType,Object key){
		T _result = null;
		Map<Object,Object> _impls = this.getContainer().get(annotationType.getName());
		if( !CollectionUtils.isEmpty(_impls) ){
			if( _impls.containsKey(key) ){
				_result = (T) _impls.get(key);
			}
		}
		return _result;
	}
   
   /***
    * 获取单类型注册的所有策略
    * @param annotationType
    * @return
    */
   @SuppressWarnings("unchecked")
   public <K,V> Map<K,V> getImpls(Class<? extends Annotation> annotationType){
	   return (Map<K,V>)this.getContainer().get(annotationType.getName());
   }
}

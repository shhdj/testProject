package com.estproject.service.uklink.Dispatch;

import java.lang.annotation.Annotation;
import java.util.Map;

import com.etong.framework.controls.dispatcher.api.DispatchApi;

/**
 * 策略工具
 * @author  YZH
 * @version 1.0
 * @date 2016年4月14日
 */
public final class DispatchUtils {
   /***
    * 构造器
    */
   private DispatchUtils(){}
   
   /***
    * 获取处理对象
    * @param annotationType
    * @param key
    * @return
    */
   public static <T> T  getImpl(Class<? extends Annotation> annotationType,Object key){
	   return DispatchApi.getInstance().getImpl(annotationType, key);
   }
   
   /***
    * 获取处理对象集合
    * @param annotationType
    * @return
    */
   public static <K,V> Map<K,V> getImpls(Class<? extends Annotation> annotationType){
	   return DispatchApi.getInstance().getImpls(annotationType);
   }
}

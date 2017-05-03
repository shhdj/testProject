package com.estproject.service.goods.annotional;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * 任务调度注解
 * @author  YZH
 * @version 1.0
 * @date 2016年4月14日
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DispatchAnnotation {
	String value() default "";
}

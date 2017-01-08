package com.storesales.tools;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class ConvertSqlTool {

	
	public static String getFieldsString(Class cls){
		StringBuilder sb = new StringBuilder();
		Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            if(i==0){
            	sb.append(fieldName);
            }else{
            	sb.append(","+fieldName);
            }
        }
		return sb.toString();
	}
	
	public static String getFieldsAlias(Class cls){
		StringBuilder sb = new StringBuilder();
		Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            String fieldName = field.getName();
            if(i==0){
            	sb.append(":"+fieldName);
            }else{
            	sb.append(",:"+fieldName);
            }
        }
		return sb.toString();
	}
	
	
	 /**  
     * 取出bean 属性和值  
     * @param obj  
     * @return  
     * @throws Exception  
     */  
    public static Map<Object,Object> getFileValue(Object obj) throws Exception{  
        Map<Object, Object> map = new HashMap<Object, Object>();  
        Class<?> cls = obj.getClass();  
        Method methods[] = cls.getDeclaredMethods();  
        Field fields[] = cls.getDeclaredFields();  
          
        for(Field field:fields){  
              
            String fldtype = field.getType().getSimpleName();  
            String getMetName = pareGetName(field.getName());  
            String result ="";  
            if(!checkMethod(methods,getMetName)){  
                continue;  
            }  
            Method method = cls.getMethod(getMetName, null);  
            Object object = method.invoke(obj, new Object[]{});  
            if(null != object){  
                if(fldtype.equals("Date")){  
                    result = fmlDate((Date)object);  
                }  
                result = String.valueOf(object);  
            }  
            map.put(field.getName(), object);  
        }  
          
        return map;  
    }  
    
    /**  
     * 拼接某属性get 方法  
     * @param fldname  
     * @return  
     */  
    public static String pareGetName(String fldname){  
        if(null == fldname || "".equals(fldname)){  
            return null;  
        }  
        String pro = "get"+fldname.substring(0,1).toUpperCase()+fldname.substring(1);  
        return pro;  
    }  
    /**  
     * 拼接某属性set 方法  
     * @param fldname  
     * @return  
     */  
    public static String pareSetName(String fldname){  
        if(null == fldname || "".equals(fldname)){  
            return null;  
        }  
        String pro = "set"+fldname.substring(0,1).toUpperCase()+fldname.substring(1);  
        return pro;  
    }  
    /**  
     * 判断该方法是否存在  
     * @param methods  
     * @param met  
     * @return  
     */  
    public static boolean checkMethod(Method methods[],String met){  
        if(null != methods ){  
            for(Method method:methods){  
                if(met.equals(method.getName())){  
                    return true;  
                }  
            }  
        }          
        return false;  
    }  
    /**  
     * 把date 类转换成string  
     * @param date  
     * @return  
     */  
    public static String fmlDate(Date date){  
        if(null != date){  
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.US);  
            return sdf.format(date);  
        }  
        return null;  
    }  
}

package com.storesales.tools;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 汉字转拼音
 * @author Administrator
 *
 */
public class ZhConvertSpell {
	 /** 
	    * 汉字转换位汉语拼音首字母，英文字符不变 
	    * @param chines 汉字 
	    * @return 拼音 
	    */  
	    public static String converterToFirstSpell(String chines){         
	        String pinyinName = "";  
	        char[] nameChar = chines.toCharArray();  
	        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();  
	        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
	        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
	        for (int i = 0; i < nameChar.length; i++) {  
	            if (nameChar[i] > 128) {  
	                try {  
	                	String[] pinyin = PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat);
	                	if(pinyin==null||pinyin.length==0){
	                		pinyinName += nameChar[i];
	                	}else{
	                		pinyinName += pinyin[0].charAt(0);  	
	                	}
	                    
	                } catch (BadHanyuPinyinOutputFormatCombination e) {  
	                    e.printStackTrace();  
	                }  
	            }else{  
	                pinyinName += nameChar[i];  
	            }  
	        }  
	        return pinyinName;  
	    }  
	   
	    /** 
	    * 汉字转换位汉语拼音，英文字符不变 
	    * @param chines 汉字 
	    * @return 拼音 
	    */  
	    public static String converterToSpell(String chines){          
	        String pinyinName = "";  
	        char[] nameChar = chines.toCharArray();  
	        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();  
	        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);  
	        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);  
	        for (int i = 0; i < nameChar.length; i++) {  
	            if (nameChar[i] > 128) {  
	                try {  
	                    pinyinName += PinyinHelper.toHanyuPinyinStringArray(nameChar[i], defaultFormat)[0];  
	                } catch (BadHanyuPinyinOutputFormatCombination e) {  
	                    e.printStackTrace();  
	                }  
	            }else{  
	                pinyinName += nameChar[i];  
	            }  
	        }  
	        return pinyinName;  
	    }  
}

package com.buildpackage.fields;


import com.buildpackage.constant.Constant;
import com.buildpackage.model.BaseField;

import tools.com.hellolibrary.hello_string.StringUtils;


public class F23 extends BaseField {
	public static final LenthType lengthtype = LenthType.fix;
	public static final StringUtils.Dir DIR = StringUtils.Dir.left;
	public static final String FiLL = "0";
	public static final String DES = "卡序列号";
	public static boolean IS_VAR_LEN = false;
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.BCD;
	public static final int NORMAL_LEN = 2;
	public static final String FIELD_INFO = 
			"DES:"+DES + "\r\n"+
			"IS_VAR_LEN:"+IS_VAR_LEN + "\r\n"+
			"FILED_TYPE:"+FILED_TYPE + "\r\n"+
			"NORMAL_LEN:"+NORMAL_LEN; 
	public F23(){}
	public F23(String fieldValue){
		value = fieldValue;
	}
}

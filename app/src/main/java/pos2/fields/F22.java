package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;
import tools.com.hellolibrary.hello_string.StringUtils;


public class F22 extends BaseField {
	public static final LenthType lengthtype = LenthType.fix;
	public static final StringUtils.Dir DIR = StringUtils.Dir.left;
	public static final String FiLL = "0";
	public static final String DES = "输入方式";
	public static boolean IS_VAR_LEN = false;
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.BCD;
	public static final int NORMAL_LEN = 2;
	public static final String FIELD_INFO = 
			"DES:"+DES + "\r\n"+
			"IS_VAR_LEN:"+IS_VAR_LEN + "\r\n"+
			"FILED_TYPE:"+FILED_TYPE + "\r\n"+
			"NORMAL_LEN:"+NORMAL_LEN; 
	public F22(){}
	public F22(String fieldValue){
		value = fieldValue;
	}
}

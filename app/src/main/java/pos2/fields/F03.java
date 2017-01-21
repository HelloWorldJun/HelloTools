package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;

/**
 * 2016��8��23��
 * by lee
 * for��3���״�����
 * DES:������Ϣ
 *
 * 
 */
public class F03 extends BaseField {
	public static final String lengtype = "fix";
	public static final String DES = "交易处理码";
	public static boolean IS_VAR_LEN = false;
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.N;
	public static final int NORMAL_LEN = 3;
	public static final String FIELD_INFO = 
			"DES:"+DES + "\r\n"+
			"IS_VAR_LEN:"+IS_VAR_LEN + "\r\n"+
			"FILED_TYPE:"+FILED_TYPE + "\r\n"+
			"NORMAL_LEN:"+NORMAL_LEN; 
	public F03(){}
	public F03(String fieldValue){
		value = fieldValue;
	}
}
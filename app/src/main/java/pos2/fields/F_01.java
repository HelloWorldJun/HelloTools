package pos2.fields;


import pos2.constant.Constant;
import pos2.model.BaseField;


public class F_01 extends BaseField {
	public static final String ORDER = "_1";
	public static final String DES = "报文长度";
	public static boolean IS_VAR_LEN = false;
	public static final Constant.FieldType FILED_TYPE = Constant.FieldType.BCD;//����Ϊ_����
	public static final int NORMAL_LEN = 2;
}

package activity.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.customview.keytool.des.algorithm.DesImpl;
import com.customview.keytool.triple_des.algorithm.TripleDesImpl;
import com.customview.keytool.triple_des.utils.TripleDesUtils;

import tools.com.hellolibrary.hello_convert.ConvertUtils;


/**
 * Created by lenovo on 2017/3/1.
 * 描述：
 */

public class Test extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         String key = "1111111111111111";
        String data = "1D474897741FBD60";
        String enResult = "";
        try {
            /*byte result []= DesUtils.encrypt(ConvertUtils.hexStringToByte(key),ConvertUtils.hexStringToByte(data),
                    DesImpl.getInstance());*/
            byte result []= DesImpl.getInstance().encrypt(key.getBytes(),ConvertUtils.hexStringToByte(data));
            Log.i("vbvb","1D474897741FBD60 des加密结果："+ConvertUtils.bytesToHexString(result));
            enResult = ConvertUtils.bytesToHexString(result);
        } catch (Exception pE) {
            pE.printStackTrace();
        }


        String key2 = "927C021361AB04981AB5A2BFDAD961921AB5A2BFDAD96192";
        String data2 = enResult;
        try {
            byte result []= TripleDesUtils.decrypt_24(ConvertUtils.hexStringToByte(key2),
                    ConvertUtils.hexStringToByte(data2),
                    TripleDesImpl.getInstance());
            Log.i("vbvb","3des解密结果："+ConvertUtils.bytesToHexString(result));
        } catch (Exception pE) {
            pE.printStackTrace();
        }

    }




    public static void launch(Context pContext) {
        pContext.startActivity(new Intent(pContext,Test.class));
    }
}

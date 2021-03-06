package activity.sale.presenter;

import com.buildpackage.fields.F02;
import com.buildpackage.fields.F03;
import com.buildpackage.fields.F04;
import com.buildpackage.fields.F11;
import com.buildpackage.fields.F14;
import com.buildpackage.fields.F22;
import com.buildpackage.fields.F23;
import com.buildpackage.fields.F25;
import com.buildpackage.fields.F35;
import com.buildpackage.fields.F36;
import com.buildpackage.fields.F41;
import com.buildpackage.fields.F42;
import com.buildpackage.fields.F49;
import com.buildpackage.fields.F52;
import com.buildpackage.fields.F55;
import com.buildpackage.fields.F60;
import com.buildpackage.fields.F62;
import com.buildpackage.fields.F64;
import com.hello.readcard.model.CardInfoModel;

import activity.sale.model.SaleReq;
import base.BaseReq;
import base.BaseSwipeCardPrt;
import base.IBaseSwipeCardAty;
import db.bill.DBPosSettingBill;
import utils.SensitiveDataUtil;

/**
 * Created by lenovo on 2017/2/24.
 * 描述：
 */

public class SalePrt extends BaseSwipeCardPrt{// implements ISalePrt{

    public SalePrt(IBaseSwipeCardAty pView) {

    }

    @Override
    public BaseReq getMsgModle(CardInfoModel pCardInfoModel) {
        SaleReq lSaleReq = new SaleReq(
                new F02(SensitiveDataUtil.hideSensitiveData(2,pCardInfoModel.getCardNo())),
                new F03("00A000"),
                new F04("000000000001"),
                new F11(DBPosSettingBill.getTraceNo()),
                new F14(SensitiveDataUtil.hideSensitiveData(14,pCardInfoModel.getValidTime())),
                new F22(getField22_2(pCardInfoModel.getSwipedMode(),pCardInfoModel.getEncrypedPwd())),
                new F23(pCardInfoModel.getCardSeqNo()),
                new F25("14"),
                new F35(SensitiveDataUtil.hideSensitiveData(35,pCardInfoModel.getTrack2())),
                new F36(SensitiveDataUtil.hideSensitiveData(36,pCardInfoModel.getTrack3())),
                new F41(DBPosSettingBill.getTerminalNo()),
                new F42(DBPosSettingBill.getMerchantNo()),
                new F49("156"),
                new F52(pCardInfoModel.getEncrypedPwd()),
                new F55(getF55ForOnlineTx()),
                new F60(SensitiveDataUtil.getEncryptionData(1,
                        new String[] {
                                pCardInfoModel.getCardNo(),
                                pCardInfoModel.getValidTime(),
                                "",
                                pCardInfoModel.getTrack2().replaceAll("=", "D"),
                                pCardInfoModel.getTrack3().replaceAll("=", "D")
                        })),
                new F62(DBPosSettingBill.getTraceNo()+DBPosSettingBill.getBatchNo()),
                new F64(""));
         return lSaleReq;
    }

}

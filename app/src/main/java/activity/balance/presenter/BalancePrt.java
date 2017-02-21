package activity.balance.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import activity.balance.model.BalanceReq;
import activity.balance.view.IBalanceAty;
import base.BaseReq;
import base.ReadCardTemp;
import core.CardReader;
import db.bill.DBPosSettingBill;
import models.CardInfoModel;
import pos2.fields.F02;
import pos2.fields.F03;
import pos2.fields.F11;
import pos2.fields.F14;
import pos2.fields.F22;
import pos2.fields.F23;
import pos2.fields.F25;
import pos2.fields.F35;
import pos2.fields.F36;
import pos2.fields.F41;
import pos2.fields.F42;
import pos2.fields.F49;
import pos2.fields.F52;
import pos2.fields.F55;
import pos2.fields.F60;
import pos2.fields.F62;
import pos2.fields.F64;
import pos2.model.Body_STD;
import utils.SensitiveDataUtil;

/**
 * Created by lenovo on 2017/2/5.
 * 描述：
 */
public class BalancePrt extends ReadCardTemp implements IBalancePrt{

    private final IBalanceAty mView;
    private Context mContext;
    public BalancePrt(IBalanceAty pView) {
        mContext = (Context) pView;
        mView = pView;
    }

    @Override
    public void actionQueryBalance() {
        actionReadCardProcess(this);

    }


    @Override
    public void onReadCardSucc(CardInfoModel pPardInfo) {
        CardReader.checkCardThreadIsRun = false;
        Log.i("vbvb","读卡成功："+pPardInfo.toString());
        inputTradePwdEntry(pPardInfo);
    }

    @Override
    public void onReadCardFail(String pFailMsg) {
        Log.i("vbvb","读卡失败：");
    }

    @Override
    public void onEncryPwdSucc(CardInfoModel pCardInfoModel, String pPinEncryStr) {
        Toast.makeText(mContext, "读卡且获取密码成功："+pCardInfoModel.toString()+" 密码为："+pPinEncryStr, Toast.LENGTH_SHORT).show();
        Log.i("vbvb","读卡且获取密码成功："+pCardInfoModel.toString()+" 密码为："+pPinEncryStr);
        BalanceReq lBalanceReq = new BalanceReq(
                new F02(SensitiveDataUtil.hideSensitiveData(2,pCardInfoModel.getCardNo())),
                new F03("310000"),
                new F11("000055"),//new F11(DBPosSettingBill.getTraceNo()),
                new F14(SensitiveDataUtil.hideSensitiveData(14,pCardInfoModel.getValidTime())),
                new F22(getField22(pCardInfoModel.getSwipedMode(),pPinEncryStr)),
                new F23(pCardInfoModel.getCardSeqNo()),
                new F25("14"),
                new F35(SensitiveDataUtil.hideSensitiveData(35,pCardInfoModel.getTrack2())),
                new F36(SensitiveDataUtil.hideSensitiveData(36,pCardInfoModel.getTrack3())),
                new F41(DBPosSettingBill.getTerminalNo()),
                new F42(DBPosSettingBill.getMerchantNo()),
                new F49("156"),
                new F52(pPinEncryStr),
                new F55(""),
                new F60(SensitiveDataUtil.getEncryptionData(1,
                        new String[] {
                                pCardInfoModel.getCardNo(),
                                pCardInfoModel.getValidTime(),
                                "",
                                pCardInfoModel.getTrack2().replaceAll("=", "D"),
                                pCardInfoModel.getTrack3().replaceAll("=", "D")
                        })),
                new F62("000055"+DBPosSettingBill.getBatchNo()),//new F62(DBPosSettingBill.getTraceNo()+DBPosSettingBill.getBatchNo()),
                new F64("")
        );

        lBalanceReq.actionDeal(mContext, "0200", "02,03,11,14,22,23,25,35,36,41,42,49,52,55,60,62,64", lBalanceReq, new BaseReq.ResultListener() {
            @Override
            public void succ(Body_STD pBody_std) {

            }

            @Override
            public void fail(Body_STD pBody_std) {

            }
        });
    }

    @Override
    public void onEncryPwdFail(String pErroMsg) {
        Log.i("vbvb","读卡且获取密码失败："+pErroMsg);
    }
}
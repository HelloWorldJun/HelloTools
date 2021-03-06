package com.urovo.poscommon.models;

/**
 * Created by lenovo on 2017/4/10.
 * 描述：密钥类型
 */


public enum KeyUsage {
    TRACK_KEY(1),//磁道密钥
    PIN_KEY(2),//pin密钥
    MAC_KEY(3),//mac密钥
    MASTER_KEY(4),//主密钥
    Reserved_KEY1(5),//预留1
    Reserved_KEY2(6),//预留2
    Reserved_KEY3(7),//预留3
    ;

    private int mValue;
    KeyUsage(int pValue) {
        mValue = pValue;
    }

    public int getValue() {
        return mValue;
    }
}

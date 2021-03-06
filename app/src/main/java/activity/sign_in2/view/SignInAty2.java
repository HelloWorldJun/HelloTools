package activity.sign_in2.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import activity.sign_in2.presenter.SignInPrt2;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellolibrary.hello_dialog.DialogUtil;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/1/4.
 * 描述：
 */

public class SignInAty2 extends BaseActivity implements ISignInAty2{
    private SignInPrt2 mPresenter;

    @Override
    public void onClick(View v) {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initView() {
        setContentView(R.layout.aty_sign_in);
    }

    @Override
    public void initListener() {
        DialogUtil.showProgressDialog(this,false,DialogUtil.STYLE_CIRCAL,"签到中",25);
        mPresenter.actionSign();
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {
        mPresenter = new SignInPrt2(this);
    }

    public static void launch(Context pContext){
        pContext.startActivity(new Intent(pContext,SignInAty2.class));
    }

    @Override
    public void onSignInSucc(String pMsg) {
        DialogUtil.hideProgressDialog();
        Toast.makeText(this,pMsg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignInFail(String pMsg) {
        DialogUtil.hideProgressDialog();
        Toast.makeText(this,pMsg,Toast.LENGTH_LONG).show();
    }

}

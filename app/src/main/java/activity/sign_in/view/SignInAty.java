package activity.sign_in.view;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import activity.sign_in.presenter.SignInPrt;
import tools.com.hellolibrary.hello_base.BaseActivity;
import tools.com.hellotools.R;

/**
 * Created by lenovo on 2017/1/4.
 * 描述：
 */

public class SignInAty extends BaseActivity implements ISignInAty{
    private SignInPrt mPresenter;

    @Override
    public void onSignInSucc(String pMsg) {
        Toast.makeText(this,pMsg,Toast.LENGTH_LONG);
        Log.i("vbvb","签到成功:"+pMsg);
    }

    @Override
    public void onSignInFail(String pMsg) {
        Toast.makeText(this,pMsg,Toast.LENGTH_LONG);
        Log.i("vbvb","签到失败："+pMsg);
    }

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
        mPresenter.actionSign();
    }

    @Override
    public void releaseResource() {

    }

    @Override
    public void initPresenter() {
        mPresenter = new SignInPrt(this);
    }

    public static void launch(Context pContext){
        pContext.startActivity(new Intent(pContext,SignInAty.class));
    }
}

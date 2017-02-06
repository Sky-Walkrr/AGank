package me.gchfeng.agank.mvp.ui.activity;

import android.content.Intent;
import android.view.View;

import common.AppComponent;
import common.MyActivity;
import me.gchfeng.agank.mvp.contract.MainContract;
import me.gchfeng.agank.mvp.presenter.MainPresenter;

/**
 * Created by Walker on 2017/2/6.
 */

public class MainActivity extends MyActivity<MainPresenter> implements MainContract.View{
    @Override
    protected void setupActivityComponent(AppComponent appComponent) {

    }

    @Override
    protected View initView() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void launchActivity(Intent intent) {

    }

    @Override
    public void killSelf() {

    }
}

package me.gchfeng.agank.mvp.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.jess.arms.base.DefaultAdapter;

import butterknife.BindView;
import common.AppComponent;
import common.MyActivity;
import me.gchfeng.agank.R;
import me.gchfeng.agank.dependecyInject.component.DaggerMainComponent;
import me.gchfeng.agank.dependecyInject.module.MainModule;
import me.gchfeng.agank.mvp.contract.MainContract;
import me.gchfeng.agank.mvp.presenter.MainPresenter;

/**
 * Created by Walker on 2017/2/6.
 */

public class MainActivity extends MyActivity<MainPresenter> implements MainContract.View{

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View initView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_main,null,false);
    }

    @Override
    protected void initData() {
        mPresenter.requestData(true);
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

    @Override
    public void initAdapter(DefaultAdapter adapter) {
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

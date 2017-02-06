package me.gchfeng.agank.mvp.presenter;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;

import javax.inject.Inject;

import me.gchfeng.agank.mvp.contract.MainContract;

/**
 * Created by Walker on 2017/2/6.
 */
@ActivityScope
public class MainPresenter extends BasePresenter<MainContract.Model,MainContract.View>{

    @Inject
    public MainPresenter(MainContract.Model model, MainContract.View rootView) {
        super(model, rootView);
    }
}

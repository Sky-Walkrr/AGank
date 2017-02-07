package me.gchfeng.agank.mvp.presenter;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.gchfeng.agank.mvp.contract.MainContract;
import me.gchfeng.agank.mvp.model.entity.DataObj;
import me.gchfeng.agank.mvp.model.entity.ResponseObj;
import me.gchfeng.agank.mvp.ui.adapter.MainAdapter;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Walker on 2017/2/6.
 */
@ActivityScope
public class MainPresenter extends BasePresenter<MainContract.Model,MainContract.View>{

    private int mPage = 1;
    private int count = 20;
    private String type = "Android";
    private MainAdapter adapter;
    private List<DataObj> dataList = new ArrayList<>();

    @Inject
    public MainPresenter(MainContract.Model model, MainContract.View rootView) {
        super(model, rootView);
        adapter = new MainAdapter(dataList);
        mRootView.initAdapter(adapter);
    }

    public void requestData(boolean clearCache) {
        mModel.getMainData(type,
                count,
                mPage,
                clearCache)
                .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<ResponseObj, Observable<List<DataObj>>>() {
                    @Override
                    public Observable<List<DataObj>> call(ResponseObj responseObj) {
                        return Observable.just(responseObj.getResults());
                    }
                })
                .subscribe(new Action1<List<DataObj>>() {
                    @Override
                    public void call(List<DataObj> dataObjs) {
                        if (mPage == 1) {
                            dataList.clear();
                        }
                        dataList.addAll(dataObjs);
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}

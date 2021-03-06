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
import me.jessyan.rxerrorhandler.core.RxErrorHandler;
import me.jessyan.rxerrorhandler.handler.ErrorHandleSubscriber;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
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
    private RxErrorHandler rxErrorHandler;

    @Inject
    public MainPresenter(MainContract.Model model, MainContract.View rootView,RxErrorHandler rxErrorHandler) {
        super(model, rootView);
        adapter = new MainAdapter(dataList);
        mRootView.initAdapter(adapter);
        this.rxErrorHandler = rxErrorHandler;
    }

    public void requestData(boolean clearCache) {
        mModel.getMainData(type,
                count,
                mPage,
                clearCache)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())//subscribeOn和observeOn顺序搞错导致网络请求和处理数据失败。。。
                .flatMap(new Func1<ResponseObj, Observable<List<DataObj>>>() {
                    @Override
                    public Observable<List<DataObj>> call(ResponseObj responseObj) {
                        return Observable.just(responseObj.getResults());
                    }
                })
                .subscribe(new ErrorHandleSubscriber<List<DataObj>>(rxErrorHandler) {
                    //errorHandler to handle the error..
                    @Override
                    public void onNext(List<DataObj> dataObjs) {
                        if (mPage == 1) {
                            dataList.clear();
                        }
                        dataList.addAll(dataObjs);
                        adapter.notifyDataSetChanged();
                    }
                });
    }
}

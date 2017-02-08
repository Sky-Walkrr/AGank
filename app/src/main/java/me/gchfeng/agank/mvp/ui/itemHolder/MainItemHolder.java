package me.gchfeng.agank.mvp.ui.itemHolder;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.widget.imageloader.ImageLoader;

import butterknife.BindView;
import common.MyApplication;
import me.gchfeng.agank.R;
import me.gchfeng.agank.mvp.model.entity.DataObj;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Walker on 2017/2/7.
 */

public class MainItemHolder extends BaseHolder<DataObj>{

    @BindView(R.id.tvContent)
    TextView tvContent;
    @BindView(R.id.tvTitle)
    TextView tvTitle;

    private MyApplication myApplication;
    private ImageLoader imageLoader;

    public MainItemHolder(View itemView) {
        super(itemView);
//        myApplication = (MyApplication) itemView.getContext().getApplicationContext();
//        imageLoader = myApplication.getAppComponent().imageLoader();
    }

    @Override
    public void setData(final DataObj data) {
        Observable.just(data)
                .map(new Func1<DataObj, String>() {
                    @Override
                    public String call(DataObj dataObj) {
                        return data.getDesc();
                    }
                })
//                .flatMap(new Func1<ResponseObj, Observable<List<DataObj>>>() {
//                    @Override
//                    public Observable<List<DataObj>> call(ResponseObj responseObj) {
//                        return Observable.just(responseObj.getResults());
//                    }
//                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(RxTextView.text(tvTitle));
        Observable.just(data)
                .map(new Func1<DataObj, String>() {
                    @Override
                    public String call(DataObj dataObj) {
                        return data.getWho();
                    }
                })
                .filter(new Func1<String, Boolean>() {
                    @Override
                    public Boolean call(String s) {
                        return !TextUtils.isEmpty(s);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(RxTextView.text(tvContent));
//                .subscribe(new Action1<List<DataObj>>() {
//                    @Override
//                    public void call(List<DataObj> dataObjs) {
//                        Observable.from(dataObjs)
//                                .map(new Func1<DataObj, String>() {
//                                    @Override
//                                    public String call(DataObj dataObj) {
//                                        return dataObj.getDesc();
//                                    }
//                                })
//                                .subscribe(RxTextView.text(tvTitle));
//                    }
//                });
    }
}

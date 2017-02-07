package me.gchfeng.agank.mvp.contract;

import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.mvp.BaseView;
import com.jess.arms.mvp.IModel;

import me.gchfeng.agank.mvp.model.entity.ResponseObj;
import rx.Observable;

/**
 * Created by Walker on 2017/2/6.
 */

public interface MainContract {

    interface View extends BaseView {
        void initAdapter(DefaultAdapter adapter);
    }

    interface Model extends IModel {
        Observable<ResponseObj> getMainData(String type,int count,int page,boolean update);
    }
}

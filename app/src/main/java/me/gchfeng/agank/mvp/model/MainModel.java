package me.gchfeng.agank.mvp.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import io.rx_cache.DynamicKey;
import io.rx_cache.EvictProvider;
import io.rx_cache.Reply;
import me.gchfeng.agank.mvp.contract.MainContract;
import me.gchfeng.agank.mvp.model.entity.ResponseObj;
import me.gchfeng.agank.mvp.model.request.cache.CacheManager;
import me.gchfeng.agank.mvp.model.request.service.ServiceManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by gchfeng on 2017/2/6.
 */
@ActivityScope
public class MainModel extends BaseModel<ServiceManager,CacheManager> implements MainContract.Model{

    @Inject
    public MainModel(ServiceManager serviceManager, CacheManager cacheManager) {
        super(serviceManager, cacheManager);
    }

    @Override
    public Observable<ResponseObj> getMainData(String type, int count, int page,boolean update) {
        Observable<ResponseObj> objObservable = mServiceManager.getDataService().getData(type,count,page);
        return mCacheManager.getDataCache()
                .getData(objObservable,
                        new DynamicKey(page),
                        new EvictProvider(update))
                .map(new Func1<Reply<ResponseObj>, ResponseObj>() {
                    @Override
                    public ResponseObj call(Reply<ResponseObj> responseObjReply) {
                        return responseObjReply.getData();
                    }
                });
    }
}

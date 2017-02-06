package me.gchfeng.agank.mvp.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import me.gchfeng.agank.mvp.contract.MainContract;
import me.gchfeng.agank.mvp.model.request.cache.CacheManager;
import me.gchfeng.agank.mvp.model.request.service.ServiceManager;

/**
 * Created by gchfeng on 2017/2/6.
 */
@ActivityScope
public class MainModel extends BaseModel<ServiceManager,CacheManager> implements MainContract.Model{

    @Inject
    public MainModel(ServiceManager serviceManager, CacheManager cacheManager) {
        super(serviceManager, cacheManager);
    }
}

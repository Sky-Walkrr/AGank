package me.gchfeng.agank.mvp.model.request.service;

import com.jess.arms.http.BaseServiceManager;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Walker on 2017/2/6.
 */
@Singleton
public class ServiceManager implements BaseServiceManager{

    private DataService dataService;

    /**
     * 如果需要添加service只需在构造方法中添加对应的service,
     * 在提供get方法返回出去,只要在ServiceModule提供了该service Dagger2会自行注入
     */
    @Inject
    public ServiceManager(DataService dataService) {
        this.dataService = dataService;
    }

    public DataService getDataService() {
        return dataService;
    }

    @Override
    public void onDestroy() {

    }
}

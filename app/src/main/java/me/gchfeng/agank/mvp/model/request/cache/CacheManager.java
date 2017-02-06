package me.gchfeng.agank.mvp.model.request.cache;

import com.jess.arms.http.BaseCacheManager;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by gchfeng on 2017/2/6.
 */
@Singleton
public class CacheManager implements BaseCacheManager {
    private DataCache dataCache;

    @Inject
    public CacheManager(DataCache dataCache) {
        this.dataCache = dataCache;
    }

    public DataCache getDataCache() {
        return dataCache;
    }

    @Override
    public void onDestory() {

    }
}

package me.gchfeng.agank.dependecyInject.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache.internal.RxCache;
import me.gchfeng.agank.mvp.model.request.cache.DataCache;

/**
 * Created by gchfeng on 2017/2/6.
 */
@Module
public class CacheModule {

    @Singleton
    @Provides
    DataCache provideDataCache(RxCache rxCache){
        return rxCache.using(DataCache.class);
    };
}

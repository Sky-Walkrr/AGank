package me.gchfeng.agank.dependecyInject.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.gchfeng.agank.mvp.model.request.service.DataService;
import retrofit2.Retrofit;

/**
 * Created by Walker on 2017/2/6.
 */
@Module
public class ServiceModule {

    @Provides
    @Singleton
    DataService provideDataService(Retrofit retrofit) {
        return retrofit.create(DataService.class);
    }


}

package me.gchfeng.agank.dependecyInject.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import me.gchfeng.agank.mvp.contract.MainContract;

/**
 * Created by Walker on 2017/2/6.
 */
@Module
public class MainModule {
    private MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    @ActivityScope
    MainContract.View provideView() {
        return this.view;
    }

    @Provides
    @ActivityScope
    MainContract.MainModel provideModel(MainContract.MainModel mainModel) {
        return mainModel;
    }
}

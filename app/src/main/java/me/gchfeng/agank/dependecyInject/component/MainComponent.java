package me.gchfeng.agank.dependecyInject.component;

import com.jess.arms.di.scope.ActivityScope;

import common.AppComponent;
import dagger.Component;
import me.gchfeng.agank.dependecyInject.module.MainModule;
import me.gchfeng.agank.mvp.ui.activity.MainActivity;

/**
 * Created by Walker on 2017/2/6.
 */

@ActivityScope
@Component(modules = MainModule.class,dependencies = AppComponent.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}

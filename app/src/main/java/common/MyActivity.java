package common;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.mvp.Presenter;


public abstract class MyActivity<P extends Presenter> extends BaseActivity<P> {
    protected MyApplication mWeApplication;
    @Override
    protected void ComponentInject() {
        mWeApplication = (MyApplication) getApplication();
        setupActivityComponent(mWeApplication.getAppComponent());
    }

    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupActivityComponent(AppComponent appComponent);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.mWeApplication = null;
    }
}

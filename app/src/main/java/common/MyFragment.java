package common;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.mvp.Presenter;
import com.squareup.leakcanary.RefWatcher;


public abstract class MyFragment<P extends Presenter> extends BaseFragment<P> {
    protected MyApplication myApplication;
    @Override
    protected void ComponentInject() {
        myApplication = (MyApplication)mActivity.getApplication();
        setupFragmentComponent(myApplication.getAppComponent());
    }

    //提供AppComponent(提供所有的单例对象)给子类，进行Component依赖
    protected abstract void setupFragmentComponent(AppComponent appComponent);

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher watcher = MyApplication.getRefWatcher(getActivity());//使用leakCanary检测fragment的内存泄漏
        if (watcher != null) {
            watcher.watch(this);
        }
        this.myApplication =null;
    }
}

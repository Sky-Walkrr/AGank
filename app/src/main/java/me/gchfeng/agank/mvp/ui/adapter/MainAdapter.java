package me.gchfeng.agank.mvp.ui.adapter;

import android.view.View;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;

import me.gchfeng.agank.R;
import me.gchfeng.agank.mvp.model.entity.DataObj;
import me.gchfeng.agank.mvp.ui.itemHolder.MainItemHolder;

/**
 * Created by Walker on 2017/2/7.
 */

public class MainAdapter extends DefaultAdapter<DataObj>{

    public MainAdapter(List<DataObj> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<DataObj> getHolder(View v) {
        return new MainItemHolder(v);
    }

    @Override
    public int getLayoutId() {
        return R.layout.adapter_item_main;
    }
}

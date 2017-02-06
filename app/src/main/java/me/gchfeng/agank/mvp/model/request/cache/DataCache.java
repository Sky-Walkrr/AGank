package me.gchfeng.agank.mvp.model.request.cache;

import java.util.concurrent.TimeUnit;

import io.rx_cache.LifeCache;
import io.rx_cache.Reply;
import me.gchfeng.agank.mvp.model.entity.ResponseObj;
import rx.Observable;

/**
 * Created by gchfeng on 2017/2/6.
 */

public interface DataCache {
    @LifeCache(duration = 5,timeUnit = TimeUnit.MINUTES)
    Observable<Reply<ResponseObj>> getData();
}

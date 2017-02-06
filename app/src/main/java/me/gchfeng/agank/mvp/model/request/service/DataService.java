package me.gchfeng.agank.mvp.model.request.service;

import me.gchfeng.agank.mvp.model.entity.ResponseObj;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 获取分类数据
 * Created by Walker on 2017/2/6.
 */

public interface DataService {
    //http://gank.io/api/data/Android/10/1

    @GET("/data/{type}/{count}/{page}")
    Observable<ResponseObj> getData (@Path("type") String type,@Path("count") int count,@Path("page") int page);


}

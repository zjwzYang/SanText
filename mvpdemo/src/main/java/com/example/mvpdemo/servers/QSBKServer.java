package com.example.mvpdemo.servers;

import com.example.mvpdemo.QiBean.QSBKBean;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by yfx on 16/10/22.
 */
public interface QSBKServer {
    @GET("/article/list/pic?page=1")
    Call<QSBKBean> getQSBKBean();

}

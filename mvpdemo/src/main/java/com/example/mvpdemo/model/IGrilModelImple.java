package com.example.mvpdemo.model;

import com.example.mvpdemo.Datas;
import com.example.mvpdemo.QiBean.QSBKBean;
import com.example.mvpdemo.servers.QSBKServer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yfx on 16/10/22.
 */
public class IGrilModelImple implements IGrilModel {
    @Override
    public void loadGril(final GrilOnLoadListener grilOnLoadListener) {
        //加载数据
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Datas.path)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        QSBKServer qsbkServer = retrofit.create(QSBKServer.class);
        Call<QSBKBean> qsbkBean = qsbkServer.getQSBKBean();
        qsbkBean.enqueue(new Callback<QSBKBean>() {
            @Override
            public void onResponse(Call<QSBKBean> call, Response<QSBKBean> response) {
                grilOnLoadListener.onComplete(response.body());
            }

            @Override
            public void onFailure(Call<QSBKBean> call, Throwable t) {

            }
        });
    }
}

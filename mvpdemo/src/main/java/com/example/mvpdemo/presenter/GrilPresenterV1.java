package com.example.mvpdemo.presenter;

import com.example.mvpdemo.QiBean.QSBKBean;
import com.example.mvpdemo.model.IGrilModel;
import com.example.mvpdemo.model.IGrilModelImple;
import com.example.mvpdemo.view.IGrilView;

import java.lang.ref.WeakReference;

/**
 * Created by yfx on 16/10/22.
 */
public class GrilPresenterV1 {
    IGrilModel iGrilModel=new IGrilModelImple();
    IGrilView iGrilView;

    //通过构造方法
    public GrilPresenterV1(IGrilView iGrilView) {
        this.iGrilView = iGrilView;
    }

    //绑定model和view
    public void fetch(){
        //显示进度条
        iGrilView.showLoading();
        //让model加载数据
        if (iGrilModel!=null){
            iGrilModel.loadGril(new IGrilModel.GrilOnLoadListener() {
                @Override
                public void onComplete(QSBKBean qsbkBean) {
                    //给view显示
                    iGrilView.showGirls(qsbkBean);
                }
            });
        }




    }





}

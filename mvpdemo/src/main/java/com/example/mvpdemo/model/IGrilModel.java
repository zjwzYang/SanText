package com.example.mvpdemo.model;

import com.example.mvpdemo.QiBean.QSBKBean;

/**
 * Created by yfx on 16/10/22.
 */
public interface IGrilModel {

    void loadGril(GrilOnLoadListener grilOnLoadListener);

    /**
     * jianting
     */
    interface GrilOnLoadListener{
        void  onComplete(QSBKBean qsbkBean);
    }

}

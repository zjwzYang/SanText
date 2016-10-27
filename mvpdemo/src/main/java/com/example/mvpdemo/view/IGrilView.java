package com.example.mvpdemo.view;

import com.example.mvpdemo.QiBean.QSBKBean;

/**
 * Created by yfx on 16/10/22.
 */
public interface IGrilView {
    //显示数据
    void showGirls(QSBKBean qsbkBean);
    //加载进度条
    void showLoading();
}

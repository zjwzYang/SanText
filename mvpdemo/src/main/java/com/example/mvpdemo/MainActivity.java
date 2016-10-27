package com.example.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mvpdemo.QiBean.QSBKBean;
import com.example.mvpdemo.adapter.LVAdapter;
import com.example.mvpdemo.presenter.GrilPresenterV1;
import com.example.mvpdemo.view.IGrilView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IGrilView{
    private ListView listView;
    //model:业务逻辑
    //view:视图
    //presenter:中间者(绑定model和view)
    //view持有presenter
    //presenter持有model的接口类型

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listview);
        //中间者 加载数据
        new GrilPresenterV1(this).fetch();




    }

    @Override
    public void showGirls(QSBKBean qsbkBean) {
        List<QSBKBean.ItemsBean> items = qsbkBean.getItems();
        LVAdapter lvAdapter = new LVAdapter(MainActivity.this, items);
        listView.setAdapter(lvAdapter);


    }

    @Override
    public void showLoading() {
        Toast.makeText(MainActivity.this,"加载中",Toast.LENGTH_SHORT).show();
    }
}

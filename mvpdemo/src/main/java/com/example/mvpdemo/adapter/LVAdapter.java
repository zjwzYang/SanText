package com.example.mvpdemo.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mvpdemo.QiBean.QSBKBean;
import com.example.mvpdemo.R;

import java.util.List;

/**
 * Created by yfx on 16/10/22.
 */
public class LVAdapter extends BaseAdapter {

    private Context context;
    private List<QSBKBean.ItemsBean> dataList;

    public LVAdapter(Context context, List<QSBKBean.ItemsBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder viewHolder;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.tvContent = (TextView) view.findViewById(R.id.tv_content);
            viewHolder.tvLogin = (TextView) view.findViewById(R.id.tv_login);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        QSBKBean.ItemsBean itemsBean = dataList.get(position);
        if (itemsBean != null && itemsBean.getHot_comment() != null && !TextUtils.isEmpty(itemsBean.getHot_comment().getContent())) {
            viewHolder.tvContent.setText(itemsBean.getHot_comment().getContent());
        }
        if (itemsBean != null && itemsBean.getUser() != null && !TextUtils.isEmpty(itemsBean.getUser().getLogin())) {
            viewHolder.tvLogin.setText(itemsBean.getUser().getLogin());
        }

        return view;
    }

    class ViewHolder {
        TextView tvContent;
        TextView tvLogin;
    }
}

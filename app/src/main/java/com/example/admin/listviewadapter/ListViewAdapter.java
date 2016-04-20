package com.example.admin.listviewadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/4/20.
 */
public class ListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Map<String, Object>> listItems;
    private LayoutInflater listContainer;
    private boolean[] hasChecked;

    public final class ListItemView {
        public ImageView image;
        public TextView title;
        public TextView info;
        public CheckBox check;
        public Button detail;
    }

    public ListViewAdapter(Context context, List<Map<String, Object>> listItems) {
        this.context = context;
        listContainer = LayoutInflater.from(context);
        this.listItems = listItems;
        hasChecked = new boolean[getCount()];
    }

    public int getCount() {
        return listItems.size();
    }

    public Object getItem(int arg0) {
        return null;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        Log.e("method", "getView");
        final int selectID = position;
        ListItemView listItemView = null;
        if (convertView == null) {
            listItemView = new ListItemView();
            convertView = listContainer.inflate(R.layout.list_item, null);
            listItemView.image = (ImageView)convertView.findViewById(R.id.imageItem);
            listItemView.title = (TextView)convertView.findViewById(R.id.titleItem);
        }

    }
}

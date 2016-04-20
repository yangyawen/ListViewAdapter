package com.example.admin.listviewadapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import butterknife.InjectView;

public class MainActivity extends Activity {

    @InjectView(R.id.list_goods)
    ListView listView;
    @InjectView(R.id.imgbt_sum)
    ImageButton imgbt_sum;

    private List<Map<String, Object>> listItems;
    private ListViewAdapter listViewAdapter;
    private Integer[] imgeIDs = {R.drawable.animal1, R.drawable.animal2, R.drawable.animal3, R.drawable.animal4, R.drawable.animal5, R.drawable.animal1};
    private String[] goodsNames = {"蛋糕", "礼物", "邮票", "爱心", "鼠标", "音乐CD"};
    private String[] goodsDetails = {
            "蛋糕：好好吃。",
            "礼物：李青青钟",
            "邮票：环游世界",
            "爱心：世界都有爱",
            "鼠标：反应敏捷。",
            "音乐CD：酷我音乐。"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgbt_sum.setOnClickListener(new ClickEvent());
        listItems = getListItems();
        listViewAdapter = new ListViewAdapter(this, listItems);
        listView.setAdapter(listViewAdapter);
    }

    private List<Map<String, Object>> getListItems() {
        List<Map<String, Object>> listItems = new ArrayList<>();
        for (int i = 0; i < goodsNames.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("image", imgeIDs[i]);
            map.put("title", "物品名称：");
            map.put("info", goodsNames[i]);
            map.put("detail", goodsDetails[i]);
            listItems.add(map);
        }
        return listItems;
    }

    class ClickEvent implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            String goodsList = "";
            for (int i = 0; i < listItems.size(); i++) {
                goodsList += listViewAdapter.hasChecked(i) ? goodsNames[i] + " " : "";
            }

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("购物清单：")
                    .setMessage("你好，你选择了如下商品：\n" + goodsList)
                    .setPositiveButton("确定", null)
                    .show();
        }
    }
}

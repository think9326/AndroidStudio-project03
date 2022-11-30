package com.example.project03;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ListView extends AppCompatActivity {
    android.widget.ListView lv;
    //放入图片
    int[] pics = {R.drawable.lion, R.drawable.tiger, R.drawable.monkey,
            R.drawable.dog, R.drawable.cat, R.drawable.elephant};
    String[] names = {"Lion", "Tiger", "Monkey", "Dog", "Cat", "Elephant"};

    HashMap<View, Boolean> vis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.listview);

        vis = new HashMap<>();

        //查找组件
        lv = (android.widget.ListView) findViewById(R.id.lv);

        //填充数据
        ArrayList<HashMap<String, Object>> lst = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 6; i++) {
            HashMap<String, Object> mp = new HashMap<>();
            mp.put("name", names[i]);
            mp.put("pic", pics[i]);
            lst.add(mp);
        }

        //设置填充
        SimpleAdapter sa = new SimpleAdapter(this, lst, R.layout.layoutitem,
                new String[]{"name", "pic"}, new int[]{R.id.tv_name1, R.id.iv_pic1});
        lv.setAdapter(sa);
    }

    //选中按钮
    public void click_select(View V) {
        LinearLayout l1 = V.findViewById(R.id.l1);
        TextView tv_name = V.findViewById(R.id.tv_name1);
        if (vis.get(V) == null || !vis.get(V)) {
            l1.setBackgroundColor(Color.RED);
            vis.put(V, true);
        }else {
            l1.setBackgroundColor(Color.WHITE);
            vis.put(V, false);
        }
        Toast toast = Toast.makeText(ListView.this, tv_name.getText(), Toast.LENGTH_SHORT);
        toast.show();
    }
}

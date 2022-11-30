package com.example.project03;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class ActionModeLayout extends AppCompatActivity {
    android.widget.ListView lv1;
    String names[] = {"One","Two","Three","Four","Five"};
    HashMap<View, Boolean> vis;
    int selected_items = 0;
    android.view.ActionMode am;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.actionmode);

        vis = new HashMap<>();

        lv1 = findViewById(R.id.lv1);
        ArrayList<HashMap<String, Object>> lst = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            HashMap<String, Object> mp = new HashMap<>();
            mp.put("name",names[i]);
            mp.put("pic",R.drawable.elephant);
            lst.add(mp);
        }

        SimpleAdapter sa = new SimpleAdapter(this,lst,R.layout.actionitem,new String[]{"name","pic"},
                new int[]{R.id.tv_name2,R.id.iv_pic2});
        lv1.setAdapter(sa);
    }

    public void click_select(View V) {
        if (am == null) {
            am = startActionMode(callback);
        }
        LinearLayout l2 = (LinearLayout) V;
        if (vis.get(V) == null || !vis.get(V)) {
            l2.setBackgroundColor(Color.CYAN);
            vis.put(V, true);
            selected_items++;
        }else {
            l2.setBackgroundColor(Color.WHITE);
            vis.put(V, false);
            selected_items--;
        }
        callback.onActionItemClicked(am, null);
    }

    ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            getMenuInflater().inflate(R.menu.menu_1, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            actionMode.setTitle(selected_items + "select");
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

        }
    };
}

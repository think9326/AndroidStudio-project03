package com.example.project03;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MenuLayout extends AppCompatActivity {
    TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.menu_layout);

        tv_content = findViewById(R.id.tv_content);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.minSize:
                minSize();
                break;
            case R.id.midSize:
                midSize();
                break;
            case R.id.maxSize:
                maxSize();
                break;
            case R.id.commonMenu:
                toast();
                break;
            case R.id.red:
                red();
                break;
            case R.id.black:
                black();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void minSize() {
        tv_content.setTextSize(10);
    }

    public void midSize() {
        tv_content.setTextSize(16);
    }

    public void maxSize() {
        tv_content.setTextSize(20);
    }

    public void toast() {
        Toast toast = Toast.makeText(this,"这是普通菜单项",Toast.LENGTH_SHORT);
        toast.show();
    }

    public void red() {
        tv_content.setTextColor(Color.RED);
    }

    public void black() {
        tv_content.setTextColor(Color.BLACK);
    }
}

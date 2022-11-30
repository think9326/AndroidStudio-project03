package com.example.project03;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Alert extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.alert_main);

    }
    public void click_select(View V) {
        Button btn_main = V.findViewById(R.id.btn_main);
        btn_main.setBackgroundColor(Color.WHITE);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(View.inflate(this, R.layout.alert, null));
        builder.show();
    }

    //点击返回主页
    public void click_to_next(View V) {
        Intent next = new Intent();
        next.setClass(this, MainActivity.class);
        startActivity(next);
    }
}
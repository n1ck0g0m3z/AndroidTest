package com.example.teacher.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.teacher.test.R;

import butterknife.OnClick;

public class UIActivity extends AppCompatActivity {

    @OnClick(R.id.btnIntent)
    void onBtnIntent(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);
    }
}

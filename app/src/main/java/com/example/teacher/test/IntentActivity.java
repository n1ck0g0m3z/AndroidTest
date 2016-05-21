package com.example.teacher.test;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import butterknife.OnClick;

public class IntentActivity extends AppCompatActivity {

    private final int REQUEST_CODE_FOR_SAMPLE = 1;

    private Button mBtnTest1;
    private Button mBtnTest2;
    private Button mBtnTest3;

    @OnClick(R.id.btnTest1)
    void onBtnTest1(){
        Intent intent = new Intent(IntentActivity.this,SampleActivity.class);
        intent.putExtra(SampleActivity.EXTRA_HELLO_STRING,"hello world");
        startActivity(intent);
    }
    @OnClick(R.id.btnTest2)
    void onBtnTest2(){
        Uri uri = Uri.parse("tel:090-222-333");
        Intent intent=new Intent(Intent.ACTION_DIAL,uri);
        startActivity(intent);
    }
    @OnClick(R.id.btnTest3)
    void onBtnTest3(){
        Intent intent = new Intent(IntentActivity.this,SampleActivity.class);
        intent.putExtra(SampleActivity.EXTRA_HELLO_STRING,"hello world");
        startActivityForResult(intent,REQUEST_CODE_FOR_SAMPLE);
    }
    @OnClick(R.id.btnTest4)
    void onBtntest4(){
        Intent intent = new Intent(IntentActivity.this, UIActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE_FOR_SAMPLE){
                if(data != null && data.getExtras() != null){
                    String value = data.getStringExtra("returnKey");
                    Toast.makeText(IntentActivity.this,value,Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}

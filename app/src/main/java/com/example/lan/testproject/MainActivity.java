package com.example.lan.testproject;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lan.testproject.bean.TestBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<TestBean> list = new ArrayList<>();
    private Button button;
    private Button btnShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btn);
        btnShow=findViewById(R.id.btnShow);
        list.add(new TestBean("设备三", "切割验证"));
        list.add(new TestBean("设备一", "脚本下发"));
        list.add(new TestBean("设备三", "脚本下发"));
        list.add(new TestBean("设备二", "切割验证"));
        list.add(new TestBean("设备一", "切割验证"));
        list.add(new TestBean("设备三", "切割验证"));
        list.add(new TestBean("设备二", "切割验证"));
        list.add(new TestBean("设备四", "切割验证"));
        list.add(new TestBean("设备二", "脚本下发"));
        list.add(new TestBean("设备四", "脚本下发"));

        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                //
                if (list.size()>0){
                    SortUtil.getList(list);
                }

            }
        });
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxTimerUtil.interval(5000, new RxTimerUtil.IRxNext() {
                    @Override
                    public void doNext(long number) {
                        Log.e("定时开启","指行中");
                    }
                });
            }
        });
        //app:cardElevation="0px"
        //app:cardUseCompatPadding="false"
    }



    @Override
    protected void onDestroy() {
        RxTimerUtil.cancel();
        super.onDestroy();
    }
}

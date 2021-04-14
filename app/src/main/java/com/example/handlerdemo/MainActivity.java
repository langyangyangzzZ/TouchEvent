package com.example.handlerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.handlerdemo.adapter.VpAdapter;
import com.example.handlerdemo.fragment.BlankFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewpager;
    private double FLIP_DISTANCE = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewpager = findViewById(R.id.viewpager);
        Button bt = findViewById(R.id.bt);

        bt.setOnClickListener(v -> {
            Log.i("点击事件:", "OnClick");
        });

        bt.setOnTouchListener((v, event) -> {
                    Log.i("点击事件:", "OnTouchClick" + event.getAction());
                    return true;
                }
        );
        bt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                return true;
            }
        });


        viewpager.setAdapter(new VpAdapter(getSupportFragmentManager(), getFragmentList()));


    }

    private ArrayList<Fragment> getFragmentList() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            fragments.add(new BlankFragment());
        }
        return fragments;
    }


}
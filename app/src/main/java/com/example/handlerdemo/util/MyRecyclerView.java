package com.example.handlerdemo.util;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.handlerdemo.adapter.RelAdapter;

import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;
import static android.view.MotionEvent.ACTION_UP;

/**
 * author : Tiaw.
 * date   : 4/14/21
 * 博客：https://blog.csdn.net/weixin_44819566
 * desc   :
 */
public class MyRecyclerView extends RecyclerView {


    private int mLastY;
    private int mLastX;

    public MyRecyclerView(@NonNull Context context) {
        super(context);
        init();
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        setLayoutManager(new LinearLayoutManager(getContext()));

        setAdapter(new RelAdapter());
    }

//    //内部拦截法
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        int x = (int) ev.getX();
//        int y = (int) ev.getY();
//        switch (ev.getAction()) {
//            case ACTION_DOWN://按压
//                //不让父容器拿到事件
//                getParent().requestDisallowInterceptTouchEvent(true);
//                break;
//            case ACTION_MOVE://移动
//                int moveX = x - mLastX;
//                int moveY = y - mLastY;
//                if (Math.abs(moveX) > Math.abs(moveY)) {
//                    //给父容器事件
//                    getParent().requestDisallowInterceptTouchEvent(false);
//                } else {
//                    Log.i("ACTION_MOVE", "垂直滑动");
//                }
//                break;
//            case ACTION_UP: //抬起
//                break;
//            case ACTION_CANCEL://被父容器拦截
//                Log.i("ACTION_CANCEL", "RecyclerView");
//                break;
//        }
//
//        mLastX = x;
//        mLastY = y;
//        return super.dispatchTouchEvent(ev);
//    }
}

package com.example.handlerdemo.util;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import static android.view.MotionEvent.ACTION_CANCEL;
import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_MOVE;

/**
 * author : Tiaw.
 * date   : 4/14/21
 * 博客：https://blog.csdn.net/weixin_44819566
 * desc   :
 */
public class MyViewPager extends ViewPager {


    private int mX;
    private int mY;

    public MyViewPager(@NonNull Context context) {
        super(context);
    }

    public MyViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //默认
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        return false;
//    }

//    //    //是否拦截事件 true 拦截事件  false不拦截事件
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
//            super.onInterceptTouchEvent(ev);
//
//            /*
//             *  如果是 DOWN 事件不拦截，交给子View(MyRecyclerView)处理
//             *  DOWN事件是首先判断的，如果拦截了DOWN事件，则子View RecyclerView拿不到事件
//             *
//             *   因为在dispatchTouchEvent()中首先会把DOWN事件清空
//             *
//             *   if (actionMasked == MotionEvent.ACTION_DOWN) {
//             *         cancelAndClearTouchTargets(ev);
//             *         resetTouchState();
//             *    }
//             */
//            return false;
//        }
//
//        //在move事件的时候，拦截事件
//        return true;
//    }


    //外部拦截发
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        if (ev.getAction() == ACTION_DOWN) {
            mX = (int) ev.getX();
            mY = (int) ev.getY();
        }

        if (ev.getAction() == ACTION_MOVE) {
            int moveX = mX - x;
            int moveY = mY - y;
            if (Math.abs(moveX) < Math.abs(moveY)) {
                Log.i("ACTION_MOVE", "垂直滑动");
                //如果是垂直滑动就不拦截
                return false;
            } else {
                Log.i("ACTION_MOVE", "水平滑动");
            }
        }
        return super.onInterceptTouchEvent(ev);
    }
}

package com.example.handlerdemo.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * author : Tiaw.
 * date   : 4/14/21
 * 博客：https://blog.csdn.net/weixin_44819566
 * desc   :
 */
public class VpAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;

    public VpAdapter(@NonNull FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}

package com.example.handlerdemo.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.example.handlerdemo.R;

import java.util.ArrayList;

/**
 * author : Tiaw.
 * date   : 4/14/21
 * 博客：https://blog.csdn.net/weixin_44819566
 * desc   :
 */
public class RelAdapter extends RecyclerView.Adapter<RelAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.rel_item_layout, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    int[] ints = new int[]{R.mipmap.kt1, R.mipmap.kt2, R.mipmap.kt3};

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(holder.itemView)
                .load(position % 2 == 0 ? ints[0] : position % 3 == 0 ? ints[1] : ints[2])
                .into(holder.img);

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
}

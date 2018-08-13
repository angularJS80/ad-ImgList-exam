package com.unbone.corp.imglisttry.dto;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.unbone.corp.imglisttry.R;

/**
 * Created by yongbeom on 2018. 8. 6..
 */

public class RecViewHolder extends RecyclerView.ViewHolder  {
    public ImageView img;

    public RecViewHolder(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.imageView);

    }

}

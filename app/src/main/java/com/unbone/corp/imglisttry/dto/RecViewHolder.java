package com.unbone.corp.imglisttry.dto;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.SliderLayout;
import com.unbone.corp.imglisttry.R;

import org.w3c.dom.Text;

/**
 * Created by yongbeom on 2018. 8. 6..
 */

public class RecViewHolder extends RecyclerView.ViewHolder  {
    public ImageView img;
    public TextView subject;
    public SliderLayout sliderLayout;
    public RecViewHolder(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.imageView);
        subject = (TextView) itemView.findViewById(R.id.txt_subject);
        sliderLayout = (SliderLayout) itemView.findViewById(R.id.slider);

    }

}

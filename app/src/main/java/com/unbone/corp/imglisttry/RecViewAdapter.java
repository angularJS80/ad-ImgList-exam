package com.unbone.corp.imglisttry;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.unbone.corp.imglisttry.dto.ImgItem;
import com.unbone.corp.imglisttry.dto.RecViewHolder;

import java.util.ArrayList;

/**
 * Created by yongbeom on 2018. 8. 6..
 */

public class RecViewAdapter extends RecyclerView.Adapter<RecViewHolder>{

    ArrayList<ImgItem> arrayList;
    Context viewContext;

    public ArrayList<ImgItem> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<ImgItem> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    // parent 는 MainActivity 의 컨텍스트를 소유 하고 있다.
    // 컨텍스트를 소유 하고 있는 parent 의 형태는 View Group 이다.

    // 어뎁터에서 한건 한건의 레이아웃을 표현 해주기 위해 뷰홀더 를 사용
    // 그 한한건 한건의 레이아웃을 정의 하기 위해서 xml 파일을 읽어 서 view 로 정의 하려면
    //  xml 파일을 읽어 와야 되는데 그것을 수행하는것이 LayoutInflater
    // LayoutInflater 는 엑티비티 처럼 setContentView 를 사용 하지는 못하고
    // 대신 엑티비티가 가지고 있는 context 를 인자값으로 받음으로서 읽어 오도록 할 수 있다.

    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        this.viewContext = parent.getContext();


        View itmeView = LayoutInflater.from(this.viewContext).inflate(R.layout.img_item ,parent,false);

        RecViewHolder viewHolder = new RecViewHolder(itmeView);
        return viewHolder;
    }









/*

    @Override
    public MoviViewHolder onCreateViewHolder22(ViewGroup parent, int viewType) {

        this.viewContext = parent.getContext();
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movi_item, parent, false);
        MoviViewHolder viewHolder = new MoviViewHolder(v);

        picasso = new  Picasso.Builder(viewContext)
                .memoryCache(new LruCache(24000))
                .build();

        return viewHolder;

    }
*/


    @Override
    public void onBindViewHolder(RecViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

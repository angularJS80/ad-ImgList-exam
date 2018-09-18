package com.unbone.corp.imglisttry;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

//import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;
import com.unbone.corp.imglisttry.dto.ImgItem;
import com.unbone.corp.imglisttry.dto.RecViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yongbeom on 2018. 8. 6..
 */

public class RecViewAdapter extends RecyclerView.Adapter<RecViewHolder>{

    ArrayList<ImgItem> arrayList;
    Context viewContext;
    Picasso picasso;

    public ArrayList<ImgItem> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<ImgItem> arrayList) {
        this.arrayList = arrayList;
        super.notifyDataSetChanged();
    }

/*
     https://medium.com/@marudxlab/getbasecontext-%EC%99%80-getapplicationcontext-14ff3e0755b3

     1. Context 는 어디에 정의 되어있는가?
     MainActivity 상속 클레스를 추적해본다.
     추적하다보면 ContextWrapper extends Context  까지 도달한다.
     일단 컨텍스트는 클레스라고 단정 가능하다.
     컨텍스트 클레스를 살펴보면 대략 file , service ,display 와 같이 os 에서 접근 가능한 수준의 변수들이 정의 되어있다.
     이로서 컨텍스는 os 수준에 서 사용 가능한 접근을 엑티비티가 할 수 있게 한다.

     2.Context 를통해서 file, service , display 에 접근해서 무엇을 하는가 ?
      - 기본적으로 엑티비티에서 onCreate 메소드내에 xml 레이아웃 파일을 로드 시키는것도 컨텍스트가 없다면 불가능
      - setContentView(R.layout.activity_main)
      - 위의 셋컨텐츠 뷰 역시 불어보면 "layout_inflater" 를 엑티비티 가 제공하는 메서드 를 통해서 제공된다.

        엑티비티가 가진 컨텍스트를 이용해 화면을 전개 한것이라고 볼 수 있다.

        결과적으로 가져온 화면은 View 형태의 변수에 담을수 있게 된다.

     3.View 또는 ViewGroup 에서 컨텍스트를 가져온이유

      - View 는 버튼 텍스트와 같은 TextView , Button 과 같은 작은 영역이라 1단 이해 한다.

      - ViewGroup 는 이것을 포함하는 레이아웃 또는 복수형 레이아웃위젯(리스트뷰)


      - 소스를 추적해보면 ViewGroup extends View 와 같은것을 볼수 있다.
      - 자바 해쉬멥을 여러개 만들어 어래이 리스트에 담을수 있고 담은 리스트를 해쉬맵에 담을수 있다.
      - Tree 구조 형태가 가능하다는것

     4.View.
      뷰나 뷰그룹은 생성 목적이 엑티비티에 표현 하기 위함이며, 따라서 생성도 엑티비티 내에서 이루어 진다.
      이때 해당 엑티비티를 컨텍스트 형태로 생성자에 전달하여 컨텍스트에서 제공하는 기능을 사용 할수 있다.

      ViewGroup 는 뷰홀더가 생성 되는 시점에 리사이클 리스트뷰를 뷰그룹형태로 받을수 있다. 오버라이드 형태로 구현됨에 따라
      엑티비티에서 생성되는 시점이 시작점이며, 뷰그룹을 받는지점이 끝점으로 그사이의 지점은 내장 라이브러리 문서를 참조해야 한다.



     */
    @Override
    public RecViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        this.viewContext = parent.getContext();

        View itmeView = LayoutInflater.from(this.viewContext).inflate(R.layout.img_item ,parent,false);

        RecViewHolder viewHolder = new RecViewHolder(itmeView);

        picasso = new  Picasso.Builder(viewContext)
                .memoryCache(new LruCache(24000))
                .build();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecViewHolder holder, int position) {
        Log.d(" onBindViewHolder",position+"");
        Map optionMap = new HashMap();
        optionMap.put("blur",false);
        ImgItem holderImgItem = arrayList.get(position);
        holder.subject.setText(holderImgItem.getImgSubject());

        /*String imgUrl = imgItem.getImgUrl();

        //if(imgItem.getImgUrl() == null || imgItem.getImgUrl().equals("")){
        if(imgUrl==null || imgUrl.equals("")){
            picasso.with(this.viewContext)
                    .load(R.drawable.dongas)
                    .into(holder.img);
        }else{
            picasso.with(this.viewContext)
                    .load(imgItem.getImgUrl())
                    .transform(new CustomTransformation(this.viewContext, 100,optionMap))
                    .into(holder.img);
        }*/

        if(holderImgItem.getSubImgItems()!=null){
            List<ImgItem> sliderImgItems = holderImgItem.getSubImgItems();

            for(int i=0;i<holderImgItem.getSubImgItems().size();i++){
                ImgItem sliderImgItem =  sliderImgItems.get(i);



                TextSliderView textSliderView = new TextSliderView(this.viewContext);
                textSliderView
                        .description(sliderImgItem.getImgSubject())
                        .image(sliderImgItem.getImgUrl())
                        .setOnSliderClickListener(new BaseSliderView.OnSliderClickListener() {
                            @Override
                            public void onSliderClick(BaseSliderView slider) {
                               // Toast.makeText(viewContext, "", Toast.LENGTH_SHORT).show();
                               // holder.sliderLayout.getScrollBarSize();

                                //holder.sliderLayout.setCurrentPosition( holder.sliderLayout.getScrollBarSize()-1);

                                //holder.sliderLayout.startAutoCycle();
                                //holder.sliderLayout.stopAutoCycle();

                                //Log.d("currentPos",""+holder.sliderLayout.getCurrentPosition());

                                //holder.sliderLayout.moveNextPosition();


                            }
                        });

                textSliderView.bundle(new Bundle());
                textSliderView.getBundle()
                        .putString("extra",String.valueOf(i));

                holder.sliderLayout.addSlider(textSliderView);


            }
            holder.sliderLayout.stopAutoCycle();
        }

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}

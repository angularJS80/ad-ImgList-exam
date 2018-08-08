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


    // 1. Context 추적 시작
    // MainActivity 상속 클레스를 추적해본다.
    // 추적하다보면 ContextWrapper extends Context  까지 도달한다.
    // 일단 컨텍스트는 클레스라고 단정 가능하다.
    // 컨텍스트 클레스를 살펴보면 대략 file , service ,display 와 같이 os 에서 접근 가능한 수준의 변수들이 정의 되어있다.
    // 이로서 컨텍스는 os 수준에 서 사용 가능한 접근을 엑티비티가 할 수 있게 한다고 해도 과언이 아니다.
    /*
      아래 onCreate 메소드내에 화면을 엑티비티에 로드 시키기위해 수행되는 메서드이다.
    - setContentView(R.layout.activity_main)

    - 다르게 표현하면 컨텍스트 클레스에 정의된 화면을 로드하는 기능은
      "layout_inflater" 를 엑티비티 가 제공하는 메서드 를 통해서 제공된다.
      결과적으로 가져온 화면은 View 형태의 변수에 담을수 있게 된다.
      엑티비티가 가진 컨텍스트를 이용해 화면을 전개 한것이라고 볼 수 있다.
      화면을 전계 하려면 컨텍스트가 필요하다는것
      엑티비티에서 리스트를 표현하기 위해 리스트뷰와 어뎁터를 만들었다면
      리스트 뷰부터 무엇인지 봐야 한다. 리스트 뷰는 여러 뷰를 포함할 수 있는 뷰그룹형태이다.
      아이템을 보함하고 있는 어레이 리스트처럼 단수를 보함하는 복수개념이다.
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

package com.unbone.corp.imglisttry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;


import com.unbone.corp.imglisttry.dto.ImgItem;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    RecyclerView recView;
    RecViewAdapter recViewAdapter ;
    ArrayList<ImgItem> arrayList = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        defineData();
        testData();
        defineView();

        defineProc();

    }




    private void defineData() {

        ImgItem imgIitem = new ImgItem();
        imgIitem.setImgSubject("김화가 1작품");
        imgIitem.setImgUrl("http://naver/2~.jpg");

        arrayList.add(imgIitem);

        imgIitem = new ImgItem();
        imgIitem.setImgSubject("김화가 1작품");
        imgIitem.setImgUrl("http://naver/2~.jpg");
        arrayList.add(imgIitem);


    }



    public void testData() {
        for(int i=0;i<arrayList.size();i++){
            ImgItem imgItem = (ImgItem) arrayList.get(i);
        }
    }


    public void test2Data() {
        for(int i=0;i<arrayList.size();i++){
            ImgItem hashMap = arrayList.get(i);
        }
    }



    private void defineView() {
        recView = findViewById(R.id.rec_view);

    }


    private void defineProc(){

        recViewAdapter = new RecViewAdapter();
        recViewAdapter.setArrayList(arrayList);
        recView.setAdapter(recViewAdapter);
    }


}

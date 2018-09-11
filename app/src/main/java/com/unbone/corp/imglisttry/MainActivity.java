package com.unbone.corp.imglisttry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
        defineView();


        //testData();

        defineData();
        defineProc();

    }




    private void defineData() {

        ImgItem imgIitem = new ImgItem();
        imgIitem.setImgSubject("김화가 1작품");
        imgIitem.setImgUrl("");

        arrayList.add(imgIitem);

        imgIitem = new ImgItem();
        imgIitem.setImgSubject("메트릭스");
        imgIitem.setImgUrl("https://f4.bcbits.com/img/a2045320818_16.jpg");
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



FireBaseModel fireBaseModel = new FireBaseModel();
fireBaseModel.fireBaseNoneAuth();

ImgItem imgItem = new ImgItem();
        imgItem.setImgUrl("http://123456.jpg");
        imgItem.setImgSubject("artist0101");
        fireBaseModel.addData(imgItem);

fireBaseModel.getImgList();

        recView.setAdapter(
                recViewAdapter
        );

        // 차주 설명
        recView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

    }



}

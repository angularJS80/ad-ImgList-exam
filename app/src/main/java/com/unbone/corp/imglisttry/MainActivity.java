package com.unbone.corp.imglisttry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
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
        imgIitem.setImgUrl("https://f4.bcbits.com/img/a2045320818_16.jpg");

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

    private String imgUplad(){
        return "https://scontent-atl3-1.cdninstagram.com/vp/99061f6ca4b7e9bdec6170662c673cea/5C31CA43/t51.2885-15/e35/36476359_277119832866177_6778734062799421440_n.jpg";
    }

    private void defineProc(){

        recViewAdapter = new RecViewAdapter();
        recViewAdapter.setArrayList(arrayList);



        FireBaseModel fireBaseModel = new FireBaseModel();
        fireBaseModel.fireBaseNoneAuth();


        fireBaseModel.setAdapter(recViewAdapter);
        // 리사이클러 뷰에 사용중인 어뎁터를 파이어베이스에도 할당
        recView.setAdapter(recViewAdapter);
        // 리사이클러 뷰에 어벧터 할당




        ArrayList<ImgItem> imgItems = new ArrayList<ImgItem>();




        ImgItem sliderImgItem = new ImgItem();
        sliderImgItem.setImgUrl(imgUplad());
        sliderImgItem.setImgSubject("artist0101");
        imgItems.add(sliderImgItem);




        sliderImgItem = new ImgItem();
        sliderImgItem.setImgUrl("https://scontent-atl3-1.cdninstagram.com/vp/463bc7edc3a9cb9acf71624bdecdfabf/5C29820C/t51.2885-15/e35/36465708_2311560175526971_4252103896048074752_n.jpg");
        sliderImgItem.setImgSubject("artist0101");
        imgItems.add(sliderImgItem);

        sliderImgItem = new ImgItem();
        sliderImgItem.setImgUrl("https://scontent-atl3-1.cdninstagram.com/vp/ae82c4ac4f5681bc95ae944cdc7c43d7/5C2256E8/t51.2885-15/e35/36160964_194219044621710_4092911281114185728_n.jpg");
        sliderImgItem.setImgSubject("artist0101");
        imgItems.add(sliderImgItem);

        ImgItem holderImgItem = new ImgItem();
        holderImgItem.setSubImgItems(imgItems);
        holderImgItem.setImgSubject("artist0101");
        holderImgItem.setImgUrl("https://f4.bcbits.com/img/a2045320818_16.jpg");


        //fireBaseModel.addData(holderImgItem); // ImgItem 형태의 인스턴스를 파이어베이스에 등록




        //recView.setLayoutManager(new LinearLayoutManager(this));
        // 차주 설명
        //recView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL));

        fireBaseModel.getImgList(); // 파이어베이스 감시자 실행 (목록에 표현 목적)
    }



}

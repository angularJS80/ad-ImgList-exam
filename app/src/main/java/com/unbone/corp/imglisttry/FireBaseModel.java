package com.unbone.corp.imglisttry;

import android.content.Context;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.unbone.corp.imglisttry.dto.ImgItem;

import junit.framework.Test;
import junit.framework.TestCase;

import java.io.FileInputStream;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yongbeom on 2018. 9. 3..
 */

public class FireBaseModel {
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    private Gson gson = new Gson();
    private Context mContext;
    private RecViewAdapter recViewAdapter;




    private ArrayList<ImgItem> mArrayList;



    public void fireBaseNoneAuth(){

        new ImgItem(); // ImgItem 설계서를 이용해서 인스턴스를 생성


        firebaseDatabase = FirebaseDatabase.getInstance(); // 파이어베이스 접근을 위한 자원을 가져온다.
        databaseReference = firebaseDatabase.getReference(); // 그자원중 데이터베이스 레퍼런스를 가저온다
    }

    public void setListener(){
        Query query = databaseReference.child("imgList");
        query.addChildEventListener(
                new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        String name = (String)dataSnapshot.child("imgSubject").getValue();
                        String url = (String)dataSnapshot.child("imgUrl").getValue();
                        ImgItem imgItem = new ImgItem();
                        imgItem.setImgSubject(name);
                        imgItem.setImgUrl(url);


                        mArrayList.add(imgItem);
                        recViewAdapter.setArrayList(mArrayList);
                        recViewAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                        //Log.d("changed ? ","changed");
                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
        });
    }







    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) { // 데이터가 변경되면 감지하여 목록을 갱신한다.
            mArrayList = new ArrayList<ImgItem>();
            if(dataSnapshot.exists()){

                for(DataSnapshot snapshot : dataSnapshot.getChildren()){


                    ImgItem imgItem = snapshot.getValue(ImgItem.class);



                    mArrayList.add(imgItem);
                }
            }
            recViewAdapter.setArrayList(mArrayList); // 어뎁터에서는 갱신된 어레이 리스트를 확인하라고 리라이클러뷰에 알려줌

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };





    public void addData(ImgItem imgItem){
        databaseReference.child("imgList") .push().setValue(imgItem);
    }

    // 하위목록에 추가 하고 싶을때 하위 차일드를 구성하고서 푸시한다.
    public void addSubData(ImgItem sliderImgItem){
        databaseReference.child("imgList").child("subImgItems").push().setValue(sliderImgItem);
    }

    /*네이밍 변경 필요 startImgListSubscribe*/
    public void getImgList() {
        databaseReference.child("imgList").addValueEventListener(valueEventListener);
    }


    public void setAdapter(RecViewAdapter recViewAdapter) {
        this.recViewAdapter = recViewAdapter;
    }
}


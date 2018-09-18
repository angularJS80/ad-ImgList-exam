package com.unbone.corp.imglisttry.dto;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by yongbeom on 2018. 8. 6..
 */

public class ImgItem {
    private String imgUrl;
    private String imgSubject;

    private ArrayList<ImgItem> subImgItems; // ImgItem 과 동일한 형태의 복수형태(List)를 받아 들이기 위함


    public ImgItem(){ // 생성자 기본 (firebase 변환 용도로 필수 )

    }


    public String getImgUrl() {
        return imgUrl;
    }

    public String getImgSubject() {
        return imgSubject;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public void setImgSubject(String imgSubject){
        this.imgSubject = imgSubject;
    }

    public ArrayList<ImgItem> getSubImgItems() {
        return subImgItems;
    }
    public void setSubImgItems(ArrayList<ImgItem> subImgItems) {
        this.subImgItems = subImgItems;
    }
}
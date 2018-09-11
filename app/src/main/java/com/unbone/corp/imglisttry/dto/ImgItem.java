package com.unbone.corp.imglisttry.dto;

/**
 * Created by yongbeom on 2018. 8. 6..
 */

public class ImgItem {
    private String imgUrl;
    private String imgSubject;
    public ImgItem(){

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


}
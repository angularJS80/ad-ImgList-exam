package com.unbone.corp.imglisttry.dto;

import java.util.ArrayList;

/**
 * Created by yongbeom on 2018. 9. 15..
 */

class SubImgItem {
    private String imgUrl;
    private String imgSubject;



    public SubImgItem(){

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

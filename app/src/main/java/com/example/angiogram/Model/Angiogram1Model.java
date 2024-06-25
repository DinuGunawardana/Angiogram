package com.example.angiogram.Model;

import android.net.Uri;

public class Angiogram1Model {

    String userId;
    String angiogram1;
    String angiogram1Image;
    String date;

    public Angiogram1Model() {
    }

    public Angiogram1Model(String userId, String angiogram1, String angiogram1Image, String date) {
        this.userId = userId;
        this.angiogram1 = angiogram1;
        this.angiogram1Image = angiogram1Image;
        this.date = date;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAngiogram1() {
        return angiogram1;
    }

    public void setAngiogram1(String angiogram1) {
        this.angiogram1 = angiogram1;
    }

    public String getAngiogram1Image() {
        return angiogram1Image;
    }

    public void setAngiogram1Image(String angiogram1Image) {
        this.angiogram1Image = angiogram1Image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package com.example.nextapp;


import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class items implements Serializable {
   private String tvdesc;
   private String ivPref;
   private Float price;

    public items() {
    }

   /* public items(String tvdesc, String ivPref) {
        this.tvdesc = tvdesc;
        this.ivPref = ivPref;
   */

    public items(String tvdesc, String ivPref , float price) {
        this.tvdesc = tvdesc;
        this.ivPref = ivPref;
        this.price= price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getTvdesc() {
        return tvdesc;
    }

    public void setTvdesc(String tvdesc) {
        this.tvdesc = tvdesc;
    }

    public String getIvPref() {
        return ivPref;
    }

    public void setIvPref(String ivPref) {
        this.ivPref = ivPref;
    }
}

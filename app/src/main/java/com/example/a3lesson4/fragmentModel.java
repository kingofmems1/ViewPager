package com.example.a3lesson4;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class fragmentModel {
    String title , description ;
    int image ;

    public fragmentModel(String title, String description, int image) {
        this.title = title;
        this.description = description;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }
}

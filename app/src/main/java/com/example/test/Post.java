package com.example.test;

import com.google.gson.annotations.SerializedName;

public class Post {
//    int id;
//    String date;
//    String title;
@SerializedName("id")
    int id;
    @SerializedName("title")
    Title title;
    @SerializedName("date")
    String date;

    private class Title {
        @SerializedName("renerded")
        String renerded;
    }
}

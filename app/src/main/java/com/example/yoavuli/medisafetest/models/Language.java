package com.example.yoavuli.medisafetest.models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("ALL")
public class Language {

    @SerializedName("iso639_1")
    private String mISO639_1;

    @SerializedName("iso639_2")
    private String mISO639_2;

    @SerializedName("name")
    private String mName;

    @SerializedName("nativeName")
    private String mNativeName;


    public String getName() {
        return mName;
    }
}

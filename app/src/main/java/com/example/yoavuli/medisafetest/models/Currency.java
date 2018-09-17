package com.example.yoavuli.medisafetest.models;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Currency {

    @SerializedName("code")
    private String mCode;

    @SerializedName("name")
    private String mName;

    @SerializedName("symbol")
    private String mSymbol;


    public String getCode() {
        return mCode;
    }

    public String getName() {
        return mName;
    }

    public String getSymbol() {
        return mSymbol;
    }
}

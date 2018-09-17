package com.example.yoavuli.medisafetest.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

class RegionalBloc {

    @SuppressWarnings("unused")
    @SerializedName("acronym")
    private String mAcronym;

    @SuppressWarnings("unused")
    @SerializedName("name")
    private String mName;

    @SuppressWarnings("unused")
    @SerializedName("otherAcronyms")
    private ArrayList < String >  mOtherAcronymsList;

    @SuppressWarnings("unused")
    @SerializedName("otherNames")
    private  ArrayList < String >  mOtherNamesList;

}

package com.example.yoavuli.medisafetest.views.countryview.viewmodels;

import java.util.ArrayList;

public class CountryFieldModel {

    public CountryFieldModel(String title, ArrayList<String> values) {
        mTitle = title;
        mValues = values;
    }

    private final String mTitle;

    private final ArrayList <String> mValues;

    public String getTitle() {
        return mTitle;
    }

    public ArrayList<String> getValues() {
        return mValues;
    }
}

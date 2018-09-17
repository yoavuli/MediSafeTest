package com.example.yoavuli.medisafetest.views.countryview.viewmodels;

import java.util.ArrayList;

public class CountryViewModel {


    public CountryViewModel(String name, String localName,String flagUrl,ArrayList <CountryFieldModel> fields) {
        mName = name;
        mLocalName = localName;
        mFlagUrl = flagUrl;
        mFields = fields;

    }

    private final String mName;

    private final String mLocalName;

    private final String mFlagUrl;

    private final ArrayList < CountryFieldModel> mFields;


    public String getName() {
        return mName;
    }

    public String getLocalName() {
        return mLocalName;
    }

    public String getFlagUrl() {
        return mFlagUrl;
    }

    public ArrayList<CountryFieldModel> getFields() {
        return mFields;
    }
}

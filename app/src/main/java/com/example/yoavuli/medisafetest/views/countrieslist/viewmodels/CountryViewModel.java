package com.example.yoavuli.medisafetest.views.countrieslist.viewmodels;



public class CountryViewModel {

    public CountryViewModel(String name, String localName, String population, String flagUrl, String countryCode) {
       mName = name;
       mLocalName = localName;
       mPopulation = population;
       mFlagUrl = flagUrl;
       mCountryCode = countryCode;
    }

    private final String mName;

    private final String mLocalName;

    private final String mPopulation;

    private final String mFlagUrl;

    private final String mCountryCode;

    public String getName() {
        return mName;
    }

    public String getLocalName() {
        return mLocalName;
    }

    public String getPopulation() {
        return mPopulation;
    }

    public String getFlagUrl() {
        return mFlagUrl;
    }

    public String getCountryCode() {
        return mCountryCode;
    }
}

package com.example.yoavuli.medisafetest.models;



import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("unused")
public class Country {

    @SerializedName("name")
    private String mName;

    @SerializedName("topLevelDomain")
    private ArrayList <String > mTopLevelDomain;

    @SerializedName("alpha2Code")
    private String mAlpha2Code;

    @SerializedName("alpha3Code")
    private String mAlpha3Code;

    @SerializedName("callingCodes")
    private ArrayList <String > mCallingCodes;

    @SerializedName("capital")
    private String mCapital;

    @SerializedName("altSpellings")
    private ArrayList <String> mAltSpellings;

    @SerializedName("region")
    private String mRegion;

    @SerializedName("subregion")
    private String mSubregion;

    @SerializedName("population")
    private int mPopulation;

    @SerializedName("latlng")
    private ArrayList < String > mLatlng;

    @SerializedName("demonym")
    private String mDemonym;

    @SerializedName("area")
    private String mArea;

    @SerializedName("gini")
    private String mGini;

    @SerializedName("timezones")
    private ArrayList < String > mTimeZones;

    @SerializedName("borders")
    private ArrayList < String > mBorders;

    @SerializedName("nativeName")
    private String mNativeName;

    @SerializedName("numericCode")
    private String mNumericCode;

    @SerializedName("currencies")
    private  ArrayList < Currency > mCurrencies;

    @SerializedName("languages")
    private  ArrayList < Language > mLanguages;

    @SerializedName("translations")
    private HashMap < String , String >  mTranslations;

    @SerializedName("flag")
    private String mFlagUrl;

    @SerializedName("cioc")
    private String mCioc;

    @SerializedName("regionalBlocs")
    private ArrayList < RegionalBloc > mRegionalBlocs;

    private ArrayList < String > mBordersNames;


    public String getName() {
        return mName;
    }

    public ArrayList<String> getTopLevelDomain() {
        return mTopLevelDomain;
    }

    public String getAlpha2Code() {
        return mAlpha2Code;
    }

    public String getAlpha3Code() {
        return mAlpha3Code;
    }

    public ArrayList<String> getCallingCodes() {
        return mCallingCodes;
    }

    public String getCapital() {
        return mCapital;
    }

    public ArrayList<String> getAltSpellings() {
        return mAltSpellings;
    }

    public String getRegion() {
        return mRegion;
    }

    public String getSubregion() {
        return mSubregion;
    }

    public int getPopulation() {
        return mPopulation;
    }

    public ArrayList<String> getLatlng() {
        return mLatlng;
    }

    public String getDemonym() {
        return mDemonym;
    }

    public String getArea() {
        return mArea;
    }

    public String getGini() {
        return mGini;
    }

    public ArrayList<String> getTimeZones() {
        return mTimeZones;
    }

    public ArrayList<String> getBorders() {
        return mBorders;
    }

    public ArrayList<String> getBordersNames() {
        return mBordersNames;
    }

    public String getNativeName() {
        return mNativeName;
    }

    public String getNumericCode() {
        return mNumericCode;
    }

    public ArrayList<Currency> getCurrencies() {
        return mCurrencies;
    }

    public ArrayList<Language> getLanguages() {
        return mLanguages;
    }

    public HashMap<String, String> getTranslations() {
        return mTranslations;
    }

    public String getFlagUrl() {
        return mFlagUrl;
    }

    public String getCioc() {
        return mCioc;
    }

    public ArrayList<RegionalBloc> getRegionalBlocs() {
        return mRegionalBlocs;
    }

    public String getCountryCode() {
        return mAlpha3Code;
    }

    public void setBordersNames(ArrayList<String> mBorders) {
        this.mBordersNames = mBorders;
    }
}

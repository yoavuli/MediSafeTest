package com.example.yoavuli.medisafetest.data;


import com.example.yoavuli.medisafetest.models.Country;
import com.example.yoavuli.medisafetest.models.enums.CountryField;
import com.example.yoavuli.medisafetest.network.NetworkConsumer;
import com.example.yoavuli.medisafetest.network.NetworkFactory;
import com.example.yoavuli.medisafetest.views.countryview.viewmodels.CountryViewDataModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DataManager implements DataProvider {

    private static DataManager mManager;
    private HashMap <String,Country > mCountryList = new HashMap<>();

    public  static synchronized DataManager getInstance(){
        if (mManager == null)
            mManager = new DataManager();
        return mManager;
    }

    @Override

    public void getCountryList(DataConsumer consumer){
        if (mCountryList.isEmpty())
            downloadCountryList(consumer);
        else
            sortList(consumer);

    }

    @SuppressWarnings("unchecked")
    @Override
    public void getCountry(DataConsumer consumer, String code) {

        Country country = getBorderCountries(mCountryList.get(code));
        List <CountryField> fields = getFieldOrder();
        consumer.onDataReady(new DataModel(new CountryViewDataModel(country,fields)));
    }


    @SuppressWarnings("unchecked")
    private void sortList(DataConsumer consumer) {
        consumer.onDataReady(new DataModel(mCountryList.values()));
    }

    private Country getBorderCountries(Country country){

        ArrayList <String> boarderNames = new ArrayList<>();
        if (country.getBordersNames() != null && country.getBordersNames().size() > 0 )
            return country;

        if (country.getBorders().size() == 0) {
            boarderNames.add( " None" ) ;
        }
        else{
            for (String boarder : country.getBorders())
                boarderNames.add(mCountryList.get(boarder).getName());
        }
        country.setBordersNames(boarderNames);
        return country;
    }

    // This is business logic that may come from other source.
    // for now logic is in DataManager
    private List<CountryField> getFieldOrder() {
        return Arrays.asList(CountryField.Population, CountryField.Capitol, CountryField.Demonym
                , CountryField.Region, CountryField.Subregion, CountryField.Area, CountryField.Borders, CountryField.CallingCodes,
                CountryField.Currencies,CountryField.Gini, CountryField.Languages, CountryField.Timezones);
    }

    private void downloadCountryList(final DataConsumer consumer) {
        NetworkFactory.getNetworkProvider().getURL(new NetworkConsumer() {
            @Override
            public void onDownloadFinished(String result) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                gsonBuilder.setLenient();
                Gson gson = gsonBuilder.create();
                List<Country> countryList = gson.fromJson(result,  new TypeToken<List<Country>>(){}.getType());
                for (Country country: countryList){
                    mCountryList.put(country.getCountryCode(),country);
                }
                sortList(consumer);
            }

            @Override
            public void onError(String error) {
                sortList(consumer);
            }
        }, "https://restcountries.eu/rest/v2/all");
    }


}

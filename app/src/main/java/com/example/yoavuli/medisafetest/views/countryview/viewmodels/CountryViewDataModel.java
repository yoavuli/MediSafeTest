package com.example.yoavuli.medisafetest.views.countryview.viewmodels;

import com.example.yoavuli.medisafetest.models.Country;
import com.example.yoavuli.medisafetest.models.enums.CountryField;

import java.util.List;

public class CountryViewDataModel {

    public CountryViewDataModel(Country country, List<CountryField> countryFieldOrder) {
        mCountry = country;
        mCountryFieldOrder = countryFieldOrder;
    }

    private final Country mCountry;

    private final List<CountryField> mCountryFieldOrder;

    public Country getCountry() {
        return mCountry;
    }

    public List<CountryField> getFieldsOrder() {
        return mCountryFieldOrder;
    }
}

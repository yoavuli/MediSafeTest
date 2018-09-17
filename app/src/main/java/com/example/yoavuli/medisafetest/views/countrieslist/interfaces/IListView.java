package com.example.yoavuli.medisafetest.views.countrieslist.interfaces;

import com.example.yoavuli.medisafetest.views.countrieslist.viewmodels.CountryViewModel;

import java.util.ArrayList;

public interface IListView {

    void updateList(ArrayList <CountryViewModel> list);

    void openCountryView(String code);
}

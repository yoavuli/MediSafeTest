package com.example.yoavuli.medisafetest.views.countrieslist.interfaces;


public interface IListPresenter {
    void init();
    void onItemClicked(String code);
    void onSortClicked(String state);
}

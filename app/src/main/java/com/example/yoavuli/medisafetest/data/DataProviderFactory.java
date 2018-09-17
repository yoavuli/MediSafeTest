package com.example.yoavuli.medisafetest.data;

public class DataProviderFactory {

    public static DataProvider getDataProvider(){

        return DataManager.getInstance();
    }
}

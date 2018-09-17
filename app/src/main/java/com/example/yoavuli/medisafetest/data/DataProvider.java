package com.example.yoavuli.medisafetest.data;

public interface DataProvider {

   void getCountryList(DataConsumer consumer);
   void getCountry(DataConsumer consumer , String code);
}

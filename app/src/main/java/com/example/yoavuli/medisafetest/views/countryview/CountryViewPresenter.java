package com.example.yoavuli.medisafetest.views.countryview;

import com.example.yoavuli.medisafetest.MiscUtils;
import com.example.yoavuli.medisafetest.data.DataConsumer;
import com.example.yoavuli.medisafetest.data.DataModel;
import com.example.yoavuli.medisafetest.data.DataProviderFactory;
import com.example.yoavuli.medisafetest.models.Country;
import com.example.yoavuli.medisafetest.views.countryview.interfaces.ICountryView;
import com.example.yoavuli.medisafetest.views.countryview.interfaces.ICountryViewPresenter;
import com.example.yoavuli.medisafetest.views.countryview.viewmodels.CountryFieldModel;
import com.example.yoavuli.medisafetest.views.countryview.viewmodels.CountryViewDataModel;
import com.example.yoavuli.medisafetest.views.countryview.viewmodels.CountryViewModel;

import java.util.ArrayList;


public class CountryViewPresenter implements ICountryViewPresenter , DataConsumer {


    private final ICountryView mView;

    public CountryViewPresenter(ICountryView countryViewActivity) {

        mView = countryViewActivity;
    }


    @Override
    public void setCountryCode(String code) {
        DataProviderFactory.getDataProvider().getCountry(this,code);
    }

    @Override
    public void onDataReady(DataModel data) {
        CountryViewDataModel dataModel = (CountryViewDataModel) data.getData();
        Country country =dataModel.getCountry();
        ArrayList <CountryFieldModel > fields = new ArrayList<>();
        for (int i =0 ; i <dataModel.getFieldsOrder().size() ; i ++){
            fields.add(MiscUtils.getFieldModel(country,dataModel.getFieldsOrder().get(i)));
        }
        CountryViewModel viewModel = new CountryViewModel(country.getName(),country.getNativeName(),
                country.getFlagUrl(),fields);
        mView.onDataReady(viewModel);
        }
}

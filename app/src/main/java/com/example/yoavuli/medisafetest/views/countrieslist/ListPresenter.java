package com.example.yoavuli.medisafetest.views.countrieslist;



import com.example.yoavuli.medisafetest.MiscUtils;
import com.example.yoavuli.medisafetest.data.DataConsumer;
import com.example.yoavuli.medisafetest.data.DataModel;
import com.example.yoavuli.medisafetest.data.DataProviderFactory;
import com.example.yoavuli.medisafetest.models.Country;
import com.example.yoavuli.medisafetest.models.enums.SortStates;
import com.example.yoavuli.medisafetest.views.countrieslist.interfaces.IListPresenter;
import com.example.yoavuli.medisafetest.views.countrieslist.interfaces.IListView;
import com.example.yoavuli.medisafetest.views.countrieslist.viewmodels.CountryViewModel;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;


public class ListPresenter implements IListPresenter, DataConsumer {

    private final IListView mView;
    private SortStates mSortState = SortStates.AlphabeticalBottom;


    public ListPresenter(IListView listView) {
        mView = listView;
    }

    private void getSortedList() {
        DataProviderFactory.getDataProvider().getCountryList(this);
    }

    @Override
    public void init() {
        getSortedList();
    }



    @Override
    public void onItemClicked(String code) {
        mView.openCountryView(code);
    }

    @Override
    public void onSortClicked(String state) {

        switch (state){
            default:
            case "Alphabetical A to Z":
                mSortState = SortStates.AlphabeticalTop;
                break;
            case  "Alphabetical Z to A":
                mSortState = SortStates.AlphabeticalBottom;
                break;
            case "Population Top":
                mSortState = SortStates.PopulationTop;
                break;
            case "Population Bottom":
                mSortState = SortStates.PopulationBottom;
                break;
        }
        getSortedList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onDataReady(DataModel data) {

        ArrayList<Country> list = new ArrayList<>((Collection<Country>) data.getData());
        Collections.sort(list,getComparator());
        ArrayList <CountryViewModel> itemList = new ArrayList<>();
        for (Country country :list){
            itemList.add(new CountryViewModel(country.getName() , country.getNativeName() , MiscUtils.addSuffix(country.getPopulation()),
                    country.getFlagUrl() , country.getAlpha3Code()));
        }
        mView.updateList(itemList);    }

    private Comparator<Country> getComparator() {
                return  new Comparator<Country>() {

                    @Override
                    public int compare(com.example.yoavuli.medisafetest.models.Country country, com.example.yoavuli.medisafetest.models.Country other) {
                        switch (mSortState){
                            default:
                            case AlphabeticalTop:
                                return country.getName().compareTo(other.getName());
                            case AlphabeticalBottom:
                                return other.getName().compareTo(country.getName());
                            case PopulationBottom:
                                return country.getPopulation() - other.getPopulation();
                            case PopulationTop:
                                return other.getPopulation() - country.getPopulation();
                        }
                    }
                };
    }

}

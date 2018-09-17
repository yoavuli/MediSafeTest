package com.example.yoavuli.medisafetest.views.countrieslist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.yoavuli.medisafetest.R;
import com.example.yoavuli.medisafetest.views.countrieslist.interfaces.IListPresenter;
import com.example.yoavuli.medisafetest.views.countrieslist.interfaces.IListView;
import com.example.yoavuli.medisafetest.views.countrieslist.interfaces.ItemListClickListener;
import com.example.yoavuli.medisafetest.views.countrieslist.viewmodels.CountryViewModel;
import com.example.yoavuli.medisafetest.views.countryview.CountryViewActivity;

import java.util.ArrayList;

import static com.example.yoavuli.medisafetest.Constants.COUNTRY_CODE;

public class ListActivity extends Activity implements IListView {

    private IListPresenter mPresenter;
    private CountryListAdapter mAdapter;
    private Spinner spnSort;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        initViews();
        mPresenter = new ListPresenter(this);
        mPresenter.init();
    }

    private void initViews() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CountryListAdapter(new ItemListClickListener() {
            @Override
            public void onItemClicked(String code) {
                mPresenter.onItemClicked(code);
            }
        });
        recyclerView.setAdapter(mAdapter);
        spnSort = findViewById(R.id.spnSort);
        spnSort.setSelection(0);
        spnSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mPresenter.onSortClicked(((TextView)view).getText().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                mPresenter.onSortClicked(((TextView)spnSort.getSelectedView()).getText().toString());

            }
        });



    }


    ///Update the Countries list
    @Override
    public void updateList(ArrayList<CountryViewModel> list) {
        mAdapter.setItemList(list);
    }


    //Opens a new view - Country view
    @Override
    public void openCountryView(String code) {
        Intent intent = new Intent(this,CountryViewActivity.class);
        intent.putExtra(COUNTRY_CODE,code);
        startActivity(intent);
    }
}

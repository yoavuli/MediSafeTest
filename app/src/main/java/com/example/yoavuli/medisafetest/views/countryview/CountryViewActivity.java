package com.example.yoavuli.medisafetest.views.countryview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.example.yoavuli.medisafetest.Constants;
import com.example.yoavuli.medisafetest.R;
import com.example.yoavuli.medisafetest.views.countryview.interfaces.ICountryView;
import com.example.yoavuli.medisafetest.views.countryview.interfaces.ICountryViewPresenter;
import com.example.yoavuli.medisafetest.views.countryview.viewmodels.CountryFieldModel;
import com.example.yoavuli.medisafetest.views.countryview.viewmodels.CountryViewModel;

public class CountryViewActivity extends Activity implements ICountryView{

    @SuppressWarnings("FieldCanBeLocal")
    private ICountryViewPresenter mPresenter;
    private ImageView imgFlag;
    private TextView txtName;
    private TextView txtLocalName;
    private LinearLayout fieldsLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.country_view);
        mPresenter = new CountryViewPresenter(this);
        initViews();
        mPresenter.setCountryCode(getIntent().getStringExtra(Constants.COUNTRY_CODE));

    }

    private void initViews() {
        imgFlag = findViewById(R.id.imgFlag);
        txtName = findViewById(R.id.txtName);
        txtLocalName = findViewById(R.id.txtLocalName);
        fieldsLayout = findViewById(R.id.fieldsLayout);


    }

    @Override
    public void onDataReady(CountryViewModel viewModel) {
        txtName.setText(viewModel.getName());
        txtLocalName.setText(viewModel.getLocalName());
        SvgLoader.pluck()
                .with( this)
                .load(viewModel.getFlagUrl(), imgFlag);

        for (CountryFieldModel model: viewModel.getFields()){
            fieldsLayout.addView(new CountryFieldView(this,model));
        }

    }
}

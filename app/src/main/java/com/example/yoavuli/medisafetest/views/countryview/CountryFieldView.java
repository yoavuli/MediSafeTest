package com.example.yoavuli.medisafetest.views.countryview;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yoavuli.medisafetest.R;
import com.example.yoavuli.medisafetest.views.countryview.viewmodels.CountryFieldModel;

public class CountryFieldView extends RelativeLayout {

    public CountryFieldView(Context context, CountryFieldModel model) {
        super(context);
        init(model);
    }

    public CountryFieldView(Context context) {
        super(context);
    }

    public CountryFieldView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(CountryFieldModel model) {
       inflate(getContext(),R.layout.country_field_layout,this);
        TextView txtLabel = findViewById(R.id.txtLabel);
        txtLabel.setText(model.getTitle());
        LinearLayout valuesLayout = findViewById(R.id.valuesLayout);
        for (int i = 0; i < model.getValues().size(); i ++){
            TextView txtView = new TextView(getContext());
            txtView.setText(model.getValues().get(i));
            valuesLayout.addView(txtView);
        }



    }


}

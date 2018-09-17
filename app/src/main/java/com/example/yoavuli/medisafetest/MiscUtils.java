package com.example.yoavuli.medisafetest;

import com.example.yoavuli.medisafetest.models.Country;
import com.example.yoavuli.medisafetest.models.Currency;
import com.example.yoavuli.medisafetest.models.Language;
import com.example.yoavuli.medisafetest.models.enums.CountryField;
import com.example.yoavuli.medisafetest.views.countryview.viewmodels.CountryFieldModel;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public  class MiscUtils {


    public static String addSuffix(long count) {
        if (count < 1000) return "" + count;
        int exp = (int) (Math.log(count) / Math.log(1000));
        return String.format(Locale.ENGLISH,"%.1f%c",
                count / Math.pow(1000, exp),
                "kMGTPE".charAt(exp-1));
    }

    public static CountryFieldModel getFieldModel(Country country, CountryField field) {

        ArrayList <String> values = new ArrayList<>();
        switch (field){
            case Population:
                values.add(NumberFormat.getInstance().format(country.getPopulation()));
                break;
            case Area:
                values.add(country.getArea());
                break;
            case Gini:
                values.add(country.getGini());
                break;
            case Region:
                values.add(country.getRegion());
                break;
            case Borders:
                values.addAll(country.getBordersNames());
                break;
            case Capitol:
                values.add(country.getCapital());
                break;
            case Demonym:
                values.add(country.getDemonym());
                break;
            case CallingCodes:
                values.addAll(country.getCallingCodes());
                break;
            case Languages:
                for (Language language :country.getLanguages())
                    values.add(language.getName());
                break;
            case Subregion:
                values.add(country.getSubregion());
                break;
            case Timezones:
                values.addAll(country.getTimeZones());
                break;
            case Currencies:
                for (Currency currency: country.getCurrencies())
                    values.add(currency.getName() + " " +  currency.getSymbol()!= null ? currency.getSymbol() : "");
                break;
        }
        return new CountryFieldModel(field.toString(),values);
    }
}

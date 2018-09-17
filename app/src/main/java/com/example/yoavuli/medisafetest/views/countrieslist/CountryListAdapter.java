package com.example.yoavuli.medisafetest.views.countrieslist;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.example.yoavuli.medisafetest.R;
import com.example.yoavuli.medisafetest.views.countrieslist.interfaces.ItemListClickListener;
import com.example.yoavuli.medisafetest.views.countrieslist.viewmodels.CountryViewModel;


import java.util.ArrayList;

public class CountryListAdapter extends RecyclerView.Adapter <CountryListAdapter.CountryViewHolder >  {



    private final ItemListClickListener mListener;

    private ArrayList <CountryViewModel> mItemList = new ArrayList<>();

    public CountryListAdapter(ItemListClickListener listener) {
        mListener = listener;
    }

    public void setItemList(ArrayList<CountryViewModel> itemList) {
        mItemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viewholder_layout, parent, false);
        return new CountryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
            holder.bind(mItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }



    public class CountryViewHolder extends RecyclerView.ViewHolder {

        private TextView txtName;
        private TextView txtLocalName;
        private TextView txtPopulation;
        private ImageView imgFlag;

        CountryViewHolder(View itemView) {
            super(itemView);
            initViews();
        }

        private void initViews() {
            txtName =  itemView.findViewById(R.id.txtName);
            txtLocalName = itemView.findViewById(R.id.txtLocalName);
            txtPopulation =  itemView.findViewById(R.id.txtPopulation);
            imgFlag = itemView.findViewById(R.id.imgFlag);

        }

        void bind(CountryViewModel countryViewModel) {

            txtName.setText(countryViewModel.getName());
            txtLocalName.setText(countryViewModel.getLocalName());
            txtPopulation.setText(countryViewModel.getPopulation());
            SvgLoader.pluck()
                    .with((Activity) itemView.getContext())
                    .load(countryViewModel.getFlagUrl(), imgFlag);
            final String code = countryViewModel.getCountryCode();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mListener.onItemClicked(code);
                }
            });
            }

    }
}


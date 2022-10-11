package com.example.countries.saved_countries;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import android.widget.CompoundButton;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;


import com.example.countries.R;
import com.example.countries.details_activity.CountryDetailActivity;
import com.example.countries.retrofit.Country;

import java.util.ArrayList;
import java.util.List;

public class SavedCountriesRvAdapter extends RecyclerView.Adapter<SavedCountriesRvAdapter.CardViewObjectHolder> {
    private Context mContext;
    private List<Country> countryList = new ArrayList<Country>();

    public SavedCountriesRvAdapter(Context mContext,List<Country> countryList) {
        this.countryList = countryList;
        this.mContext = mContext;

    }


    @NonNull
    @Override
    public SavedCountriesRvAdapter.CardViewObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.saved_card_design,parent,false);
        return new SavedCountriesRvAdapter.CardViewObjectHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SavedCountriesRvAdapter.CardViewObjectHolder holder, int position) {
        /**
         * creates country object from countrylist and binds the properties of the object
         *
         */
        Country country = countryList.get(position);

        holder.countryName.setText(country.getCountryName());

        holder.checkBoxStar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    countryList.remove(country);
                }
                else{

                }
            }
        });
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, CountryDetailActivity.class);
                i.putExtra("CountryCode",country.getCode());
                mContext.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }


    public class CardViewObjectHolder extends RecyclerView.ViewHolder {
        public TextView countryName;
        public CardView cardView;
        public CheckBox checkBoxStar;


        public CardViewObjectHolder(View view){
            super(view);
            cardView = view.findViewById(R.id.cardView);
            countryName = view.findViewById(R.id.countryName);
            checkBoxStar = view.findViewById(R.id.checkBoxStar);


        }


    }
}

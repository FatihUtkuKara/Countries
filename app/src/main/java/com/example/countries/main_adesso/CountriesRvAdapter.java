package com.example.countries.main_adesso;

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

import com.example.countries.details_activity_adesso.CountryDetailActivity;
import com.example.countries.R;
import com.example.countries.retrofit_adesso.Countries;

import java.util.ArrayList;
import java.util.List;

public class CountriesRvAdapter extends RecyclerView.Adapter<CountriesRvAdapter.CardViewObjectHolder> {
    private Context mContext;
    private List<Countries> countryList = new ArrayList<Countries>();
    public static List<String> newCountryList = new ArrayList<String>();

    public CountriesRvAdapter(Context mContext) {
        this.mContext = mContext;

    }


    @NonNull
    @Override
    public CardViewObjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_design,parent,false);
        return new CardViewObjectHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewObjectHolder holder, int position) {
        Countries country = countryList.get(position);

        holder.countryName.setText(country.getCountryName());

        holder.checkBoxStar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    newCountryList.add(country.getCountryName());
                }
                else{
                    newCountryList.remove(country.getCountryName());
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

        public void setData(List<Countries> countryList){
            this.countryList.clear();
            this.countryList.addAll(countryList);
            notifyDataSetChanged();
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


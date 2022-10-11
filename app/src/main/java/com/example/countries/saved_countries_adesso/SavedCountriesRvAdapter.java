package com.example.countries.saved_countries_adesso;

import android.content.Context;
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

import java.util.ArrayList;
import java.util.List;

public class SavedCountriesRvAdapter extends RecyclerView.Adapter<SavedCountriesRvAdapter.CardViewObjectHolder> {
    private Context mContext;
    private List<String> countryList = new ArrayList<String>();

    public SavedCountriesRvAdapter(Context mContext,List<String> countryList) {
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
        String country = countryList.get(position);

        holder.countryName.setText(country);

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

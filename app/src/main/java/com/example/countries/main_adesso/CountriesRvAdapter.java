package com.example.countries.main_adesso;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countries.details_activity_adesso.CountryDetailActivity;
import com.example.countries.R;
import com.example.countries.retrofit_adesso.Country;

import java.util.ArrayList;
import java.util.List;

public class CountriesRvAdapter extends RecyclerView.Adapter<CountriesRvAdapter.CardViewObjectHolder> {
    private Context mContext;
    private List<Country> countryList = new ArrayList<Country>();
    public static List<Country> savedCountryList = new ArrayList<Country>();
    List<String> savedCountry = new ArrayList<String>() ;

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
        /**
         * creates country object from countrylist and binds the properties of the object
         *
         */
        Country country = countryList.get(position);

        holder.countryName.setText(country.getCountryName());

        holder.checkBoxStar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                /**
                 * Checking whether the country is in the savedlist and adding data accordingly
                 *
                 */
                if(isChecked) {
                    for (int i = 0; i < savedCountryList.size(); i++) {

                       if( country.getCountryName().equals(savedCountryList.get(i).getCountryName())){

                           savedCountry.add(savedCountryList.get(i).getCountryName());
                       }}
                    if (savedCountry.contains(country.getCountryName())) {
                        Toast.makeText(mContext, "This country is already exist in saved list", Toast.LENGTH_SHORT).show();

                   }
                     else {
                        savedCountryList.add(country);
                    }

                }
                else{
                    savedCountryList.remove(country);
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

        public void setData(List<Country> countryList){
            /**
             *Specifies the data type to be added to the adapter and adds the added object to the list.
             */
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


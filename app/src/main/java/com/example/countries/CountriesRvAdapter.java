package com.example.countries;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.countries.countries.Datum;
import com.example.countries.retrofit.Countries;

import java.util.ArrayList;
import java.util.List;

public class CountriesRvAdapter extends RecyclerView.Adapter<CountriesRvAdapter.CardViewObjectHolder> {
    private Context mContext;
    private List<Countries> countryList = new ArrayList<Countries>();

    public CountriesRvAdapter(Context mContext,List<Countries>countryList) {
        this.mContext = mContext;
        this.countryList = countryList;
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

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"oldu",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

       /* public void setData(List<Countries> countryList){
            this.countryList.clear();
            this.countryList.add((Countries) countryList);
            notifyDataSetChanged();
        }
 */

    public class CardViewObjectHolder extends RecyclerView.ViewHolder {
        public TextView countryName;
        public CardView cardView;


        public CardViewObjectHolder(View view){
            super(view);
            cardView = view.findViewById(R.id.cardView);
            countryName = view.findViewById(R.id.countryName);


        }


    }
}


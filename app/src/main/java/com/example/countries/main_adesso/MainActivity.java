package com.example.countries.main_adesso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.countries.R;
import com.example.countries.countries_adesso.CountryInfo;
import com.example.countries.countries_adesso.Datum;
import com.example.countries.retrofit_adesso.ApiUtils;
import com.example.countries.retrofit_adesso.Countries;
import com.example.countries.retrofit_adesso.CountriesDaoInterface;
import com.example.countries.saved_countries_adesso.SavedCountriesActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;
    private CountriesDaoInterface countriesDıf;
    private ArrayList<Countries> countryList;
    private  CountriesRvAdapter adapter;
    private Button favMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        countryList = new ArrayList<>();
        favMain = findViewById(R.id.favMain);
            favMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent yeniIntent = new Intent(MainActivity.this, SavedCountriesActivity.class);
                    startActivity(yeniIntent);

                }
            });
        countriesDıf = ApiUtils.getCountriesDaoInterface();
        adapter = new CountriesRvAdapter(MainActivity.this);
        rv.setAdapter(adapter);
        getCountry();


    }

    public void getCountry(){

        countriesDıf.getCountry(10).enqueue(new Callback<CountryInfo>() {
            @Override
            public void onResponse(Call<CountryInfo> call, Response<CountryInfo> response) {

                 List<Datum> countriesList = response.body().getData();

               List<Countries> countries = new ArrayList<Countries>();

                for (int i = 0 ; i< countriesList.size() ; i++) {
                    countries.add(new Countries(countriesList.get(i).getName(),countriesList.get(i).getCode()));
                }

                adapter.setData(countries);
            }

            @Override
            public void onFailure(Call<CountryInfo> call, Throwable t) {

            }
        });}



}
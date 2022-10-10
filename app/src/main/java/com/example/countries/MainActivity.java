package com.example.countries;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.countries.countries.CountryInfo;
import com.example.countries.countries.Datum;
import com.example.countries.retrofit.ApiUtils;
import com.example.countries.retrofit.Countries;
import com.example.countries.retrofit.CountriesDaoInterface;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // rv = findViewById(R.id.rv);
        //rv.setHasFixedSize(true);
        //rv.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        countryList = new ArrayList<>();
        getCountry();
        countriesDıf = ApiUtils.getCountriesDaoInterface();
       // adapter = new CountriesRvAdapter(MainActivity.this,countriesList);
        //rv.setAdapter(adapter);

    }

    public void getCountry(){


        countriesDıf.getCountry(10).enqueue(new Callback<CountryInfo>() {
            @Override
            public void onResponse(Call<CountryInfo> call, Response<CountryInfo> response) {

                 List<Datum> countriesList = response.body().getData();

                //Countries c1 = new Countries(countriesList.get(1).getName());
               // for (int i = 0 ; i<=10 ; i++) {
                    Log.e("Deneme", countriesList.get(1).getName());
                }
            //}

            @Override
            public void onFailure(Call<CountryInfo> call, Throwable t) {

            }
        });



/*    countriesDıf.getCountry(10).enqueue(new Callback<CountryInfo>() {
            @Override
            public void onResponse(Call<CountryInfo> call, Response<CountryInfo> response) {


                  List<Datum> countriesList =  response.body().getData();

                Countries c1 = new Countries(countriesList.get(1).getName());
                countryList.add(c1);
            } }
               /* String y1 = countriesList.get(0).getName();
          ;
                    */
        //Log.e("Deneme",y1);
                /*Countries y2 = new countriesList.get(0);


                    Countries y3 = new Countries(countriesList.get(2).getName());
                     */
        // Log.e("Deneme",c1);
        // countryList.add(c1);
                   /* countryList.add(y2);
                   ;


        //       adapter.setData(countryList);
        //Log.e("Deneme", String.valueOf(countryList.get(8).getCountryName()));


        @Override
        public void onFailure(Call<CountryInfo> call, Throwable t) {

        }*/







}

}
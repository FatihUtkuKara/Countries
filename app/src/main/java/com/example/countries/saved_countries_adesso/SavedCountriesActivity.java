package com.example.countries.saved_countries_adesso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.countries.main_adesso.CountriesRvAdapter;
import com.example.countries.R;
import com.example.countries.main_adesso.MainActivity;
import com.example.countries.retrofit_adesso.Country;

import java.util.ArrayList;
import java.util.List;


public class SavedCountriesActivity extends AppCompatActivity {
    private RecyclerView rv2;
    private  SavedCountriesRvAdapter adapter;
    private List<Country> countryList = new ArrayList<Country>();
    private Button buttonHome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_countries);
        rv2 = findViewById(R.id.rv2);
        rv2.setHasFixedSize(true);
        rv2.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL));
        buttonHome = findViewById(R.id.buttonHome);

            countryList.clear();
                 countryList= CountriesRvAdapter.savedCountryList;
                 for (int i = 0 ; i< countryList.size();i++){
                     Log.e("Denemee", String.valueOf(countryList.get(i)));


                 }
                 buttonHome.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         Intent yeniIntent = new Intent(SavedCountriesActivity.this, MainActivity.class);
                         startActivity(yeniIntent);
                     }
                 });



                 adapter =  new SavedCountriesRvAdapter(SavedCountriesActivity.this,countryList);
            rv2.setAdapter(adapter);
    }
}
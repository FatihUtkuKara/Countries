package com.example.countries.saved_countries_adesso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.countries.main_adesso.CountriesRvAdapter;
import com.example.countries.R;

import java.util.ArrayList;
import java.util.List;


public class SavedCountriesActivity extends AppCompatActivity {
    private RecyclerView rv2;
    private  SavedCountriesRvAdapter adapter;
    private List<String> countryList = new ArrayList<String>();
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
                 countryList= CountriesRvAdapter.newCountryList;
                 for (int i = 0 ; i< countryList.size();i++){
                     Log.e("Denemee",countryList.get(i));


                 }
                 buttonHome.setOnClickListener(new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {

                     }
                 });

                 adapter =  new SavedCountriesRvAdapter(SavedCountriesActivity.this,countryList);
            rv2.setAdapter(adapter);
    }
}
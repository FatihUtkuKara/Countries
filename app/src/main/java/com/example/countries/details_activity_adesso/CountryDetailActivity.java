package com.example.countries.details_activity_adesso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.countries.R;
import com.example.countries.details_adesso.CountryDetails;
import com.example.countries.details_adesso.Data;
import com.example.countries.retrofit_adesso.ApiUtils;
import com.example.countries.retrofit_adesso.CountriesDaoInterface;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryDetailActivity extends AppCompatActivity {
    public String countryCode = "";
    Data countrydetail;
    ImageView flag;
    private CountriesDaoInterface detailDıf;
    TextView detailCountryCode;
    TextView detailCountryName;
    TextView callingCode;
    TextView capital;
    Button buttonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_detail);
        detailCountryCode = findViewById(R.id.detailCountryCode);
        detailCountryName = findViewById(R.id.detailCountryName);
        capital = findViewById(R.id.capital);
        callingCode = findViewById(R.id.callingCode);
        buttonInfo = findViewById(R.id.buttonInfo);
          flag =  findViewById(R.id.flag);

        detailDıf = ApiUtils.getCountriesDaoInterface();

        if (getIntent().hasExtra("CountryCode")){
            countryCode = getIntent().getStringExtra("CountryCode");
        }

        getCountryDetail();
    }


        public void getCountryDetail() {
            /**
             * Receives data from detailDıf and transfers it to UI with populateUI method
             */

            detailDıf.getCountryDetails(countryCode).enqueue(new Callback<CountryDetails>() {
                @Override
                public void onResponse(Call<CountryDetails> call, Response<CountryDetails> response) {

                    countrydetail = response.body().getData();

                    populateUI();

                }

                @Override
                public void onFailure(Call<CountryDetails> call, Throwable t) {

                }
            });



    }


    private void populateUI() {
        /**
         * Links data received with retrofit to visual elements
         */

        // Although I could reach the image link, I could not display it in ImageView
         //String url = countrydetail.getFlagImageUri();
         //Picasso.get().load(url).into(flag);
         Log.e("Image Url",countrydetail.getFlagImageUri());

        buttonInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.wikidata.org/wiki/"+countrydetail.getWikiDataId()));
                startActivity(browserIntent);
            }
        });
        detailCountryCode.setText("Country Code: "+countrydetail.getCode());
        detailCountryName.setText(countrydetail.getName());
        callingCode.setText("Calling Code: " +countrydetail.getCallingCode());
        capital.setText("Capital: "+countrydetail.getCapital());




    }
}
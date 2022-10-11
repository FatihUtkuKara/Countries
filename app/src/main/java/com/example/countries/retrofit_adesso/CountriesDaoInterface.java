package com.example.countries.retrofit_adesso;

import com.example.countries.countries_adesso.CountryInfo;
import com.example.countries.details_adesso.CountryDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface CountriesDaoInterface {


    @GET("geo/countries/?rapidapi-key=937fd7ae42msh786c9c0f55dcc3bp19ba92jsn79ec7f5dd574")
    Call<CountryInfo> getCountry(
            @Query("limit") int limit);



    @GET("geo/countries/{code}/?rapidapi-key=937fd7ae42msh786c9c0f55dcc3bp19ba92jsn79ec7f5dd574")
    Call<CountryDetails> getCountryDetails(
            @Path(value = "code",encoded = true ) String code);





}

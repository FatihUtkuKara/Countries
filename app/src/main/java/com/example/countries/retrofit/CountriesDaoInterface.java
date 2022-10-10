package com.example.countries.retrofit;

import com.example.countries.countries.CountryInfo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface CountriesDaoInterface {
    @GET("geo/countries/?rapidapi-key=937fd7ae42msh786c9c0f55dcc3bp19ba92jsn79ec7f5dd574")
    Call<CountryInfo> getCountry(
            @Query("limit") int limit);
            //@Path(value = "/?rapidapi-key=937fd7ae42msh786c9c0f55dcc3bp19ba92jsn79ec7f5dd574",encoded = true)String rapidapi




}

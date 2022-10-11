package com.example.countries.retrofit_adesso;

public class ApiUtils {

    public static  final String BaseUrl = "https://wft-geo-db.p.rapidapi.com/v1/";

    public static CountriesDaoInterface getCountriesDaoInterface(){
        return RetrofitClient.getClient(BaseUrl).create(CountriesDaoInterface.class);

    }
}

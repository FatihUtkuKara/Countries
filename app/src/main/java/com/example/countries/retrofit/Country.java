package com.example.countries.retrofit;

public class Country {
    private String countryName;
    private String code;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    public String getCountryName() {
        return countryName;
    }



    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }



    public Country(String countryName, String code) {
        this.countryName = countryName;
        this.code = code;

}
}

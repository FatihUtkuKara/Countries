
package com.example.countries.details_adesso; ;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Data {

    @SerializedName("capital")
    @Expose
    private String capital;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("callingCode")
    @Expose
    private String callingCode;
    @SerializedName("currencyCodes")
    @Expose
    private List<String> currencyCodes = null;
    @SerializedName("flagImageUri")
    @Expose
    private String flagImageUri;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("numRegions")
    @Expose
    private Integer numRegions;
    @SerializedName("wikiDataId")
    @Expose
    private String wikiDataId;

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCallingCode() {
        return callingCode;
    }

    public void setCallingCode(String callingCode) {
        this.callingCode = callingCode;
    }

    public List<String> getCurrencyCodes() {
        return currencyCodes;
    }

    public void setCurrencyCodes(List<String> currencyCodes) {
        this.currencyCodes = currencyCodes;
    }

    public String getFlagImageUri() {
        return flagImageUri;
    }

    public void setFlagImageUri(String flagImageUri) {
        this.flagImageUri = flagImageUri;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumRegions() {
        return numRegions;
    }

    public void setNumRegions(Integer numRegions) {
        this.numRegions = numRegions;
    }

    public String getWikiDataId() {
        return wikiDataId;
    }

    public void setWikiDataId(String wikiDataId) {
        this.wikiDataId = wikiDataId;
    }

}

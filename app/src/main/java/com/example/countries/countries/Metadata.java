
package com.example.countries.countries; ;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Metadata {

    @SerializedName("currentOffset")
    @Expose
    private Integer currentOffset;
    @SerializedName("totalCount")
    @Expose
    private Integer totalCount;

    public Integer getCurrentOffset() {
        return currentOffset;
    }

    public void setCurrentOffset(Integer currentOffset) {
        this.currentOffset = currentOffset;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

}

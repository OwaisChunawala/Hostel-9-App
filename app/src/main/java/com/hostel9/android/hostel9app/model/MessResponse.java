package com.hostel9.android.hostel9app.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by akash on 04-Dec-17.
 */

public class MessResponse {

    @SerializedName("results")
    private List<Mess> results;

    @SerializedName("total_results")
    private int totalResults;

    public List<Mess> getResults() {
        return results;
    }

    public void setResults(List<Mess> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

}

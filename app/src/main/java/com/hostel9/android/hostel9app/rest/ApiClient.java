package com.hostel9.android.hostel9app.rest;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by akash on 04-Dec-17.
 */

public class ApiClient {

    public static final String BASE_URL = "https://gymkhana.iitb.ac.in/~hostel9/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

package com.hostel9.android.hostel9app.rest;

import com.hostel9.android.hostel9app.model.Event;
import com.hostel9.android.hostel9app.model.Mess;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by akash on 04-Dec-17.
 */

public interface ApiInterface {

    @GET("messapi_day.php")
    Call<List<Mess>> getMess(/*@Query("api_key") String apiKey*/);

    @GET("messapi_week.php")
    Call<List<Mess>> getMessWeek(/*@Query("api_key") String apiKey*/);

    @GET("event_api.php")
    Call<List<Event>> getEvents(/*@Query("api_key") String apiKey*/);


//    @GET("switches/{id}")
//    Call<List<Mess>> getMessDetails(@Path("id") int id/*, @Query("api_key") String apiKey*/);
//
//    @POST("switches/")
//    Call<Mess> createMess(@Body Mess newMess);
//
//    @PUT("switches/{id}/")
//    Call<Mess> updateMess(@Body Mess newMess, @Path("id") int id);
}

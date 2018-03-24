package com.hostel9.android.hostel9app.model;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akash on 07-Mar-18.
 */

public class Event {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("venue")
    private String venue;

    @SerializedName("date")
    private String date;

    @SerializedName("time")
    private String time;

    @SerializedName("image_url")
    private String image_url;

    @SerializedName("id")
    private Integer id;

    @SerializedName("sqlId")
    private Integer sqlId;



    public Event()
    {}
    public Event(Integer id, String name, String description, String venue, String date, String time, String image_url)
    {
        this.id = id;
        this.name= name;
        this.description = description;
        this.venue = venue;
        this.date = date;
        this.time = time;
        this.image_url = image_url;

    }

    public Integer getId(){
        return id;
    }
    public  void setId(Integer id){
        this.id = id;
    }


    public String getName(){
        return name;
    }
    public  void setName(String name){
        this.name = name;
    }

    public String getDescription(){
        return description;
    }
    public  void setDescription(String description){
        this.description = description;
    }

    public String getVenue(){
        return venue;
    }
    public  void setVenue(String venue){
        this.venue = venue;
    }

    public String getDate(){
        return date;
    }
    public  void setDate(String date){
        this.date = date;
    }

    public String getTime(){
        return time;
    }
    public  void setTime(String time){
        this.time = time;
    }

    public String getImage_url(){
        return image_url;
    }
    public  void setImage_url(String image_url){
        this.image_url = image_url;
    }

    public Integer getSqlId(){
        return sqlId;
    }
    public  void setSqlId(Integer sqlId){
        this.sqlId = sqlId;
    }

}

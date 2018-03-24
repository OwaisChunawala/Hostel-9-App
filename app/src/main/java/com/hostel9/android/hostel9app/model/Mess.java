package com.hostel9.android.hostel9app.model;
import com.google.gson.annotations.SerializedName;

/**
 * Created by akash on 04-Dec-17.
 */

public class Mess {


    @SerializedName("break1")
    private String break1;

    @SerializedName("break2")
    private String break2;

    @SerializedName("lunch1")
    private String lunch1;

    @SerializedName("tiffin1")
    private String tiffin1;

    @SerializedName("lunch2")
    private String lunch2;

    @SerializedName("tiffin2")
    private String tiffin2;

    @SerializedName("dinner1")
    private String dinner1;

    @SerializedName("dinner2")
    private String dinner2;

    @SerializedName("day")
    private String day;

    private Integer id;


    public Mess()
    {}
    public Mess(Integer id, String break1, String break2, String lunch1, String lunch2, String tiffin1, String tiffin2, String dinner1, String dinner2, String day)
    {
        this.id = id;
        this.break1= break1;
        this.break2 = break2;
        this.lunch1 = lunch1;
        this.lunch2 = lunch2;
        this.tiffin1 = tiffin1;
        this.tiffin2 = tiffin2;
        this.dinner1 = dinner1;
        this.dinner2 = dinner2;
        this.day =day;

    }
//    public Mess( String name, String switch_type)
//    {
//        this.name = name;
//        this.switch_type = switch_type;
//    }
    public Integer getId(){
    return id;
}
    public  void setId(Integer id){
        this.id = id;
    }


    public String getBreak1(){
        return break1;
    }
    public  void setBreak1(String break1){
        this.break1 = break1;
    }

    public String getBreak2(){
        return break1;
    }
    public  void setBreak2(String break2){
        this.break2 = break2;
    }

    public String getLunch1(){
        return lunch1;
    }
    public  void setLunch1(String lunch1){
        this.lunch1 = lunch1;
    }

    public String getLunch2(){
        return lunch2;
    }
    public  void setLunch2(String lunch2){
        this.lunch2 = lunch2;
    }

    public String getTiffin1(){
        return tiffin1;
    }
    public  void setTiffin1(String tiffin1){
        this.tiffin1 = tiffin1;
    }

    public String getTiffin2(){
        return tiffin2;
    }
    public  void setTiffin2(String tiffin2){
        this.tiffin2 = tiffin2;
    }
    public String getDinner1(){
        return dinner1;
    }
    public  void setDinner1(String dinner1){
        this.dinner1 = dinner1;
    }

    public String getDinner2(){
        return dinner2;
    }
    public  void setDinner2(String dinner2){
        this.dinner2 = dinner2;
    }

    public String getDay(){
        return day;
    }
    public  void setDay(String day){
        this.day = day;
    }

}

package com.hostel9.android.hostel9app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class TechnicalFragment extends Fragment implements View.OnClickListener{

    //The call and mail buttons are imageView
    //Define the button object below

    ImageView rishavCall;
    ImageView rishavMail;
    ImageView mohilCall;
    ImageView mohilMail;
    ImageView trishanCall;
    ImageView trishantMail;
    ImageView gauravCall;
    ImageView gauravMail;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_technical, container, false);

        //Write your code below this

        //Define the button objects below & link to the views
        rishavCall = (ImageView) view.findViewById(R.id.rishav_call);
        rishavMail = (ImageView) view.findViewById(R.id.rishav_mail);

        trishanCall = (ImageView) view.findViewById(R.id.trishant_call);
        trishantMail = (ImageView) view.findViewById(R.id.trishant_mail);

        mohilCall = (ImageView) view.findViewById(R.id.mohanish_call);
        mohilMail = (ImageView) view.findViewById(R.id.mohanish_mail);

        gauravCall = (ImageView) view.findViewById(R.id.gaurav_call);
        gauravMail = (ImageView) view.findViewById(R.id.gaurav_mail);




        //Set onClickListeners
        rishavCall.setOnClickListener(this);
        trishanCall.setOnClickListener(this);
        mohilCall.setOnClickListener(this);
        gauravCall.setOnClickListener(this);

        rishavMail.setOnClickListener(this);
        trishantMail.setOnClickListener(this);
        mohilMail.setOnClickListener(this);
        gauravMail.setOnClickListener(this);



        //Write your code above this


        return view;
    }


    @Override
    public void onClick(View v)
    {

        if(v.getId()==R.id.rishav_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 7045800356", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.rishav_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "raj1609.rd@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.trishant_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 7757806258", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.trishant_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "trishantroy@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.mohil_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 8511112535", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.mohil_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "mohilp1998@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        if(v.getId()==R.id.gaurav_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 8291400012", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.gaurav_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "vermagaurav267@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
    }


}

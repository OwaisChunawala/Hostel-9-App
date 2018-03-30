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


public class MaintenanceFragment extends Fragment implements View.OnClickListener{

    ImageView lokeshCall;
    ImageView lokeshMail;
    ImageView sankyaCall;
    ImageView sankyaMail;
    ImageView sanjeetCall;
    ImageView sanjeetMail;
    ImageView umangCall;
    ImageView umangMail;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_maintenance, container, false);


        //Define the button objects below & link to the views
        lokeshCall = (ImageView) view.findViewById(R.id.lokesh_call);
        lokeshMail = (ImageView) view.findViewById(R.id.lokesh_mail);

        sankyaCall = (ImageView) view.findViewById(R.id.sankya_call);
        sankyaMail = (ImageView) view.findViewById(R.id.sankya_mail);

        sanjeetCall = (ImageView) view.findViewById(R.id.sanjeet_call);
        sanjeetMail = (ImageView) view.findViewById(R.id.sanjeet_mail);

        umangCall = (ImageView) view.findViewById(R.id.umang_call);
        umangMail = (ImageView) view.findViewById(R.id.umang_mail);

        lokeshCall.setOnClickListener(this);
        sankyaCall.setOnClickListener(this);
        sanjeetCall.setOnClickListener(this);
        umangCall.setOnClickListener(this);

        lokeshMail.setOnClickListener(this);
        sankyaMail.setOnClickListener(this);
        sanjeetMail.setOnClickListener(this);
        umangMail.setOnClickListener(this);



        return view;
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.lokesh_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 8828291963", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.lokesh_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "madhurisankar.kesiraju@gmail.com ")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.sankya_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 8291475065", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.sankya_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "sankhya1998@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.sanjeet_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 8291474724", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.sanjeet_mail ){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "sanjeetsahoo007@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.umang_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9974117791", null));
            startActivity(intent);
        }
        if(v.getId() == R.id.umang_mail ){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "umangkumavat17@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
    }

}
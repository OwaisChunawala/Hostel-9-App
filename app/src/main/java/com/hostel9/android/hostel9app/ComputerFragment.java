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


public class ComputerFragment extends Fragment implements View.OnClickListener {

    //The call and mail buttons are imageView
    //Define the button object below

    ImageView sahilCall;
    ImageView sahilMail;
    ImageView akashCall;
    ImageView akashMail;
    ImageView ojasCall;
    ImageView ojasMail;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_computer, container, false);

        //Write your code below this

        //Define the button objects below & link to the views
        sahilCall = (ImageView) view.findViewById(R.id.sahil_call);
        sahilMail = (ImageView) view.findViewById(R.id.sahil_mail);

        akashCall = (ImageView) view.findViewById(R.id.akash_call);
        akashMail = (ImageView) view.findViewById(R.id.akash_mail);

        ojasCall = (ImageView) view.findViewById(R.id.akash_call);
        ojasMail = (ImageView) view.findViewById(R.id.akash_mail);


        //Set onClickListeners
        sahilCall.setOnClickListener(this);
        akashCall.setOnClickListener(this);
        ojasCall.setOnClickListener(this);

        sahilMail.setOnClickListener(this);
        akashMail.setOnClickListener(this);
        ojasMail.setOnClickListener(this);



        //Write your code above this



        return view;
    }

    @Override
    public void onClick(View v)
    {

        if(v.getId()==R.id.sahil_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 8879780013", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.sahil_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "sahilsoni.iit@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.akash_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 8291474820", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.akash_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "akash.minato@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.ojas_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 7410551100", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.ojas_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "oojasgo@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
    }


}
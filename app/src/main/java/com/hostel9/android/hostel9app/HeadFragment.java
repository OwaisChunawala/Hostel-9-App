package com.hostel9.android.hostel9app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HeadFragment extends Fragment implements View.OnClickListener {

    //The call and mail buttons are imageView
    //Define the button object below

    ImageView shreerangCall;
    ImageView shreerangMail;
    ImageView abhinavCall;
    ImageView abhinavMail;
    ImageView wardeMail;
    ImageView assoMail;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_head, container, false);

        //Write your code below this

        //Define the button objects below & link to the views
        shreerangCall = (ImageView) myView.findViewById(R.id.shreerang_call);
        shreerangMail = (ImageView) myView.findViewById(R.id.shreerang_mail);
        abhinavCall = (ImageView) myView.findViewById(R.id.abhinav_call);
        abhinavMail = (ImageView) myView.findViewById(R.id.abhinav_mail) ;
        wardeMail = (ImageView) myView.findViewById(R.id.warden_mail);
        assoMail = (ImageView) myView.findViewById(R.id.asso_warden_mail);


        //Set onClickListeners
        shreerangCall.setOnClickListener(this);
        shreerangMail.setOnClickListener(this);
        abhinavMail.setOnClickListener(this);
        abhinavCall.setOnClickListener(this);
        wardeMail.setOnClickListener(this);
        assoMail.setOnClickListener(this);



        //Write your code above this
        return myView;

    }

    @Override
    public void onClick(View v){

        if(v.getId()==R.id.shreerang_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9823807911", null));
            startActivity(intent);
        }

        if(v.getId()==R.id.abhinav_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 7738694871", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.shreerang_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "sdkkaore@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        if(v.getId() == R.id.abhinav_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "abhinavbanka.ab@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        if(v.getId() == R.id.warden_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "pradeep@chem.iitb.ac.in")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId() == R.id.asso_warden_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "bm@ee.iitb.ac.in")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
    }

   }

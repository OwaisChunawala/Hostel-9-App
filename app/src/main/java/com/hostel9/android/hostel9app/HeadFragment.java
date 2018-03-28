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


        //Set onClickListeners
        shreerangCall.setOnClickListener(this);
        shreerangMail.setOnClickListener(this);



        //Write your code above this
        return myView;

    }

    @Override
    public void onClick(View v){

        if(v.getId()==R.id.shreerang_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9823807911", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.shreerang_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "sdkkaore@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
    }

   }

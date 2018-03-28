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


public class OfficeFragment extends Fragment implements View.OnClickListener{

    ImageView hallManager;
    ImageView hallBoy;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_office, container, false);

        //Write your code below this

        //Define the button objects below & link to the views
        hallManager = (ImageView) view.findViewById(R.id.hall_manager_mail);
        hallBoy = (ImageView) view.findViewById(R.id.hall_boy_call);

        hallManager.setOnClickListener(this);
        hallBoy.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.hall_boy_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9892294103", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.hall_manager_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "h9hallmgr@iitb.ac.in")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
    }

}
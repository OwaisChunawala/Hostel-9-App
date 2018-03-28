package com.hostel9.android.hostel9app.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hostel9.android.hostel9app.R;


public class FacilitiesFragment extends Fragment {

   public static Button b1,b2,b3;

    public FacilitiesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_facilities, container, false);

        b1 = v.findViewById(R.id.lib_button);
        b2 = v.findViewById(R.id.sports_button);
        b3 = v.findViewById(R.id.tech_button);

        b1.setVisibility(View.VISIBLE);
        b2.setVisibility(View.VISIBLE);
        b3.setVisibility(View.VISIBLE);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://docs.google.com/spreadsheets/d/1PNxD6tj1wIrdpElH-Ifisz2CbvmkeR_7R0LsE5xZTVQ/edit#gid=0"));

                        startActivity(browserIntent);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://docs.google.com/spreadsheets/d/1N7d-t5nssPrRLyVXhyeKoWsoXttThPSapaC-4J7ARx4/edit#gid=0"));

                startActivity(browserIntent);

            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://docs.google.com/spreadsheets/d/1keCSEzAUxyV-7gI7g5J2YoYTvcgB5Utox4RjX-z6KEE/edit#gid=0"));

                startActivity(browserIntent);
            }
        });


        // Inflate the layout for this fragment
        return v;

    }




}


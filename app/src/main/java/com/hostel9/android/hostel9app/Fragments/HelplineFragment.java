package com.hostel9.android.hostel9app.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hostel9.android.hostel9app.R;


public class HelplineFragment extends Fragment implements View.OnClickListener{


    TextView hospitalCall;
    TextView policeCall;
    TextView fireCall;

    public HelplineFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_helpline, container, false);

        hospitalCall = (TextView) view.findViewById(R.id.hospital_call);
        fireCall = (TextView) view.findViewById(R.id.fire_call);
        policeCall = (TextView) view.findViewById(R.id.police_call);

        hospitalCall.setOnClickListener(this);
        fireCall.setOnClickListener(this);
        policeCall.setOnClickListener(this);


        return view;



    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.hospital_call) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91-2225722149", null));
            startActivity(intent);
        }
        if (v.getId() == R.id.fire_call) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "022 23076111", null));
            startActivity(intent);
        }
        if (v.getId() == R.id.police_call) {
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "022 25702690", null));
            startActivity(intent);
        }

    }



    }

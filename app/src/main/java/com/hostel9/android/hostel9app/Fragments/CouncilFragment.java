package com.hostel9.android.hostel9app.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;

import com.hostel9.android.hostel9app.ComputerFragment;
import com.hostel9.android.hostel9app.CulturalFragment;
import com.hostel9.android.hostel9app.HeadFragment;
import com.hostel9.android.hostel9app.MaintenanceFragment;
import com.hostel9.android.hostel9app.MessCFragment;
import com.hostel9.android.hostel9app.R;


public class CouncilFragment extends Fragment {
 HorizontalScrollView hz;

 Button b1,b2,b3,b4,b5,b6,b7,b8;
    public CouncilFragment() {
        // Required empty public constructor
    }


     Fragment fg;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_coucil, container, false);
        hz = (HorizontalScrollView)v.findViewById(R.id.horiz);

        b1  = (Button)v.findViewById(R.id.head);
        b2  = (Button)v.findViewById(R.id.computer);
        b3  = (Button)v.findViewById(R.id.maintenance);
        b4  = (Button)v.findViewById(R.id.mess);
        b5  = (Button)v.findViewById(R.id.sports);
        b6  = (Button)v.findViewById(R.id.cultural);
        b7  = (Button)v.findViewById(R.id.technical);
        b8  = (Button)v.findViewById(R.id.office);

      

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fg = new HeadFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.def_fg,fg);
                ft.commit();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fg = new ComputerFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.def_fg,fg);
                ft.commit();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fg = new MessCFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.def_fg,fg);
                ft.commit();

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fg = new MaintenanceFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.def_fg,fg);
                ft.commit();

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fg = new ();
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.def_fg,fg);
//                ft.commit();

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fg = new CulturalFragment();
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.def_fg,fg);
                ft.commit();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fg = new ();
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.def_fg,fg);
//                ft.commit();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fg = new ();
//                FragmentManager fm = getFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.replace(R.id.def_fg,fg);
//                ft.commit();

            }
        });


        return  v ;
    }



}

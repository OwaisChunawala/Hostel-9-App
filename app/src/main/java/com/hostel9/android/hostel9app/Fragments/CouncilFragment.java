package com.hostel9.android.hostel9app.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;

import com.hostel9.android.hostel9app.Adapters.CouncilFramgentPageAdapter;
import com.hostel9.android.hostel9app.Adapters.CustomFragmentPageAdapter;
import com.hostel9.android.hostel9app.ComputerFragment;
import com.hostel9.android.hostel9app.CulturalFragment;
import com.hostel9.android.hostel9app.HeadFragment;
import com.hostel9.android.hostel9app.MaintenanceFragment;
import com.hostel9.android.hostel9app.MessCFragment;
import com.hostel9.android.hostel9app.OfficeFragment;
import com.hostel9.android.hostel9app.R;
import com.hostel9.android.hostel9app.TechnicalFragment;


public class CouncilFragment extends Fragment {
 HorizontalScrollView hz;


    private TabLayout tabLayout;
    private ViewPager viewPager;
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

//        // Inflate the layout for this fragment

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_coucil, container, false);
        tabLayout = (TabLayout)view.findViewById(R.id.council_tabs);
        viewPager = (ViewPager)view.findViewById(R.id.view_pager_council);
        viewPager.setAdapter(new CouncilFramgentPageAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }



}

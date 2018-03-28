package com.hostel9.android.hostel9app.Fragments;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.hostel9.android.hostel9app.R;


public class CMSFragment extends Fragment {

WebView wb;
    public CMSFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_cms, container, false);

        wb =(WebView) v.findViewById(R.id.WebView);
        wb.loadUrl("https://support.iitb.ac.in/support/login.jsp");
        
        WebSettings webSettings = wb.getSettings();
        webSettings.setJavaScriptEnabled(true);




        return v;
    }





}

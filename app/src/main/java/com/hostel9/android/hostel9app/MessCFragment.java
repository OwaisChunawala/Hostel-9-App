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


public class MessCFragment extends Fragment implements View.OnClickListener{

    //The call and mail buttons are imageView
    //Define the button object below

    ImageView adityaCall;
    ImageView adityaMail;
    ImageView vivekCall;
    ImageView vivekMail;
    ImageView rishiCall;
    ImageView rishiMail;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mess_c, container, false);

        //Write your code below this

        //Define the button objects below & link to the views
        adityaCall = (ImageView) view.findViewById(R.id.aditya_call);
        adityaMail = (ImageView) view.findViewById(R.id.aditya_mail);

        vivekCall = (ImageView) view.findViewById(R.id.vivek_call);
        vivekMail = (ImageView) view.findViewById(R.id.vivek_mail);

        rishiCall = (ImageView) view.findViewById(R.id.rishi_call);
        rishiMail = (ImageView) view.findViewById(R.id.rishi_mail);


        //Set onClickListeners
        adityaMail.setOnClickListener(this);
        rishiMail.setOnClickListener(this);
        vivekMail.setOnClickListener(this);

        adityaCall.setOnClickListener(this);
        vivekCall.setOnClickListener(this);
        rishiCall.setOnClickListener(this);



        //Write your code above this
        return view;
    }

    @Override
    public void onClick(View v)
    {

        if(v.getId()==R.id.aditya_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 7799323800", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.aditya_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "devallaaditya456@gmail.com ")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.vivek_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 8291473729", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.vivek_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "vivekkandeyang97@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.rishi_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9869661932", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.rishi_mail ){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "rishidhavale@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
    }



}

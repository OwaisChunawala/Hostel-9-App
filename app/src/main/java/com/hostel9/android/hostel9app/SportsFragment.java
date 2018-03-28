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


public class SportsFragment extends Fragment implements View.OnClickListener{

    //The call and mail buttons are imageView
    //Define the button object below

    ImageView manthanCall;
    ImageView manthaMail;
    ImageView pankajCall;
    ImageView pankajMail;
    ImageView shrikantCall;
    ImageView shrikantMail;
    ImageView naveenCall;
    ImageView naveenMail;
    ImageView abhishekCall;
    ImageView abhishekMail;
    ImageView nitinCall;
    ImageView nitinMail;






    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_sports, container, false);

        //Write your code below this

        //Define the button objects below & link to the views
        manthanCall = (ImageView) view.findViewById(R.id.manthan_call);
        manthaMail = (ImageView) view.findViewById(R.id.manthan_mail);

        pankajCall = (ImageView) view.findViewById(R.id.pankaj_call);
        pankajMail = (ImageView) view.findViewById(R.id.pankaj_mail);

        shrikantCall = (ImageView) view.findViewById(R.id.shrikant_call);
        shrikantMail = (ImageView) view.findViewById(R.id.shrikant_mail);

        naveenCall = (ImageView) view.findViewById(R.id.naveen_call);
        naveenMail = (ImageView) view.findViewById(R.id.naveen_mail);

        abhishekCall = (ImageView) view.findViewById(R.id.abhishek_s_call);
        abhishekMail = (ImageView) view.findViewById(R.id.abhishek_s_mail);

        nitinCall = (ImageView) view.findViewById(R.id.nitin_call);
        nitinMail = (ImageView) view.findViewById(R.id.nitin_mail);




        //Set onClickListeners
        manthanCall.setOnClickListener(this);
        pankajCall.setOnClickListener(this);
        shrikantCall.setOnClickListener(this);
        naveenCall.setOnClickListener(this);
        abhishekCall.setOnClickListener(this);
        nitinCall.setOnClickListener(this);

        manthaMail.setOnClickListener(this);
        pankajMail.setOnClickListener(this);
        shrikantMail.setOnClickListener(this);
        naveenMail.setOnClickListener(this);
        abhishekMail.setOnClickListener(this);
        nitinMail.setOnClickListener(this);


        //Write your code above this





        return view;
    }


    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.manthan_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9427015139", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.manthan_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "Manthanshingala117@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.pankaj_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9987108466", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.pankaj_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "pankajyadavky@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.shrikant_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9409238996", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.shrikant_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "sshrikantsharma98@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        if(v.getId()==R.id.naveen_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9987097165", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.naveen_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "newtonnaveenkumar@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        if(v.getId()==R.id.abhishek_s_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 8291339280", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.abhishek_s_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "gravanoid@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.nitin_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9987108691", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.nitin_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "nitinmohandeoraj@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

    }


}




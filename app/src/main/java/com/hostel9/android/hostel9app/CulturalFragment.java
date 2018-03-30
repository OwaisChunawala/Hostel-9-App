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


public class CulturalFragment extends Fragment implements View.OnClickListener{
    //The call and mail buttons are imageView
    //Define the button object below

    ImageView shyamCall;
    ImageView shyamMail;
    ImageView ramCall;
    ImageView ramMail;
    ImageView abhishekBhagatCall;
    ImageView abhishekBhagatMail;
    ImageView prajjwalCall;
    ImageView prajjwalMail;
    ImageView harshitCall;
    ImageView harshitMail;
    ImageView nihalCall;
    ImageView nihalMail;
    ImageView aryanCall;
    ImageView aryanMail;
    ImageView sohamCall;
    ImageView sohamMail;
    ImageView paramCall;
    ImageView paramMail;
    ImageView mohanishCall;
    ImageView mohanishMail;
    ImageView premCall;
    ImageView premMail;




    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cultural, container, false);

        //Write your code below this

        //Define the button objects below & link to the views
        shyamCall = (ImageView) view.findViewById(R.id.shyam_call);
        shyamMail = (ImageView) view.findViewById(R.id.shyam_mail);

        premCall = (ImageView) view.findViewById(R.id.prem_call);
        premMail = (ImageView) view.findViewById(R.id.prem_mail);


        ramCall = (ImageView) view.findViewById(R.id.ram_call);
        ramMail = (ImageView) view.findViewById(R.id.ram_mail);

        abhishekBhagatCall = (ImageView) view.findViewById(R.id.abhishek_bhagat_call);
        abhishekBhagatMail = (ImageView) view.findViewById(R.id.abhishek_bhagat_mail);

        prajjwalCall = (ImageView) view.findViewById(R.id.prajjwal_call);
        prajjwalMail = (ImageView) view.findViewById(R.id.prajjwal_mail);

        harshitCall = (ImageView) view.findViewById(R.id.harshit_call);
        harshitMail = (ImageView) view.findViewById(R.id.harshit_mail);

        nihalCall = (ImageView) view.findViewById(R.id.nihal_call);
        nihalMail = (ImageView) view.findViewById(R.id.nihal_mail);

        aryanCall = (ImageView) view.findViewById(R.id.aryan_call);
        aryanMail = (ImageView) view.findViewById(R.id.aryan_mail);

        sohamCall = (ImageView) view.findViewById(R.id.soham_call);
        sohamMail = (ImageView) view.findViewById(R.id.soham_mail);

        paramCall = (ImageView) view.findViewById(R.id.param_call);
        paramMail = (ImageView) view.findViewById(R.id.param_mail);

        mohanishCall = (ImageView) view.findViewById(R.id.mohanish_call);
        mohanishMail = (ImageView) view.findViewById(R.id.mohanish_mail);

        paramCall = (ImageView) view.findViewById(R.id.param_call);
        paramMail = (ImageView) view.findViewById(R.id.param_mail) ;


        //Set onClickListeners
        premCall.setOnClickListener(this);
        shyamCall.setOnClickListener(this);
        ramCall.setOnClickListener(this);
        abhishekBhagatCall.setOnClickListener(this);
        prajjwalCall.setOnClickListener(this);
        harshitCall.setOnClickListener(this);
        nihalCall.setOnClickListener(this);
        aryanCall.setOnClickListener(this);
        sohamCall.setOnClickListener(this);
        mohanishCall.setOnClickListener(this);
        paramCall.setOnClickListener(this);

        premMail.setOnClickListener(this);
        shyamMail.setOnClickListener(this);
        ramMail.setOnClickListener(this);
        abhishekBhagatMail.setOnClickListener(this);
        prajjwalMail.setOnClickListener(this);
        harshitMail.setOnClickListener(this);
        nihalMail.setOnClickListener(this);
        aryanMail.setOnClickListener(this);
        sohamMail.setOnClickListener(this);
        mohanishMail.setOnClickListener(this);
        paramMail.setOnClickListener(this);


        //Write your code above this

        return view;
    }


    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.shyam_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9769217121", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.shyam_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "shyambharatpatel@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.ram_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9987991947", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.ram_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "ramphalsuthar@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.abhishek_bhagat_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 7067648262", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.abhishek_bhagat_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "abhishekbhagat4159@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        if(v.getId()==R.id.prajjwal_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9967806776", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.prajjwal_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "prajjwal.14nov@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
        if(v.getId()==R.id.harshit_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 7506376720", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.harshit_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "h.baranwal98@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        if(v.getId()==R.id.nihal_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9405887565", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.nihal_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "ramteke.nihal@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        if(v.getId()==R.id.aryan_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9987991854", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.aryan_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "aryan.panhekar@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        if(v.getId()==R.id.soham_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 8454952533", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.soham_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "sdibyachintan1@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        if(v.getId()==R.id.mohanish_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 8291474994", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.mohanish_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "Mohanishverma19@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }

        if(v.getId()==R.id.prem_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 8291473881", null));
            startActivity(intent);
        }

        if(v.getId() == R.id.prem_mail){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "prem28ag@gmail.com")
                    .buildUpon()
                    .build());
            startActivity(Intent.createChooser(emailIntent, "Send email..."));

            if(v.getId()==R.id.param_call){
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", "+91 9594764738", null));
                startActivity(intent);
            }

          /*  if(v.getId() == R.id.param_mail){
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:" + "param.shah18@gmail.com")
                        .buildUpon()
                        .build());
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }*/
        }

    }




}


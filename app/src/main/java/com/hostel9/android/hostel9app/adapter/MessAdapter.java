package com.hostel9.android.hostel9app.adapter;

/**
 * Created by akash on 04-Dec-17.
 */


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.hostel9.android.hostel9app.R;
import com.hostel9.android.hostel9app.database.DatabaseHelper;
import com.hostel9.android.hostel9app.model.Mess;
import com.hostel9.android.hostel9app.rest.ApiClient;
import com.hostel9.android.hostel9app.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MessAdapter extends RecyclerView.Adapter<MessAdapter.MessViewHolder> {

    private List<Mess> Mess;
    private int rowLayout;
    private Context context;
    private final String TAG = "Updating the mess";
    DatabaseHelper db;


    public static class MessViewHolder extends RecyclerView.ViewHolder {
        LinearLayout MessLayout;
        TextView day;
        TextView break1;
        TextView lunch1;
        TextView tiffin1;
        TextView dinner1;



        public MessViewHolder(View v) {
            super(v);
            MessLayout = (LinearLayout) v.findViewById(R.id.messList);
            day = (TextView) v.findViewById(R.id.day);
            break1 = (TextView) v.findViewById(R.id.break1);
            lunch1 = (TextView) v.findViewById(R.id.lunch1);
            tiffin1 = (TextView) v.findViewById(R.id.tiffin1);
            dinner1 = (TextView) v.findViewById(R.id.dinner1);

        }
    }

    public MessAdapter(List<Mess> Mess, int rowLayout, Context context) {
        this.Mess = Mess;
        this.rowLayout = rowLayout;
        this.context = context;
        db = new DatabaseHelper(context);
    }

    @Override
    public MessAdapter.MessViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MessViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MessViewHolder holder, final int position) {
        String day1 = Mess.get(position).getDay().substring(0,3);
        String day="";
        if ("Mon".equals(day1 )) {
            day = "Monday";
        }
        else if ("Tue".equals(day1 )) {
            day = "Tuesday";
        }
        else if ("Wed".equals(day1 )) {
            day = "Wednesday";
        }
        else if ("Thu".equals(day1 )) {
            day = "Thursday";
        }
        else if ("Fri".equals(day1 )) {
            day = "Friday";
        }
        else if ("Sat".equals(day1 )) {
            day = "Saturday";
        }
        else if ("Sun".equals(day1 )) {
            day = "Sunday";
        }
        holder.day.setText(day);
        String break12 = Mess.get(position).getBreak1()+" "+Mess.get(position).getBreak2();
        holder.break1.setText(break12);
        String lunch12 = Mess.get(position).getLunch1()+" "+Mess.get(position).getLunch2();
        holder.lunch1.setText(lunch12 );
        String tiffin12 = Mess.get(position).getTiffin1()+" "+Mess.get(position).getTiffin2();
        holder.tiffin1.setText(tiffin12);
        String dinner12 = Mess.get(position).getDinner1()+" "+Mess.get(position).getDinner2();
        holder.dinner1.setText(dinner12);




    }

    @Override
    public int getItemCount() {
        return Mess.size();
    }


}
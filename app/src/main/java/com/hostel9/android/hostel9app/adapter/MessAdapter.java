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
        holder.day.setText(Mess.get(position).getDay().substring(0,3));
        String break12 = Mess.get(position).getBreak1()+" "+Mess.get(position).getBreak2();
        holder.break1.setText(break12);
        String lunch12 = Mess.get(position).getLunch1()+" "+Mess.get(position).getLunch2();
        holder.lunch1.setText(lunch12 );
        String tiffin12 = Mess.get(position).getTiffin1()+" "+Mess.get(position).getTiffin2();
        holder.tiffin1.setText(tiffin12);
        String dinner12 = Mess.get(position).getDinner1()+" "+Mess.get(position).getDinner2();
        holder.dinner1.setText(dinner12);

//        Boolean is_on = Mess.get(position).getIs_on();
//        Mess newMess = new Mess(Mess.get(position).getName(), Mess.get(position).getMess_type());

//        holder.is_on.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    // The toggle is enabled
//                    Mess newMess = new Mess(Mess.get(position).getId(),Mess.get(position).getName(), Mess.get(position).getMess_type(), true);
//                    sendNetworkRequest(newMess);
//                    db.updateMess(newMess);
//
//                } else {
//                    // The toggle is disabled
//                    Mess newMess = new Mess(Mess.get(position).getId(),Mess.get(position).getName(), Mess.get(position).getMess_type(), false);
//                    sendNetworkRequest(newMess);
//                    db.updateMess(newMess);
//
//                }
//            }
//        });



    }

    @Override
    public int getItemCount() {
        return Mess.size();
    }

//    public void sendNetworkRequest(Mess newMess)
//    {
//        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
//        Call<Mess> call = apiService.updateMess(newMess, newMess.getId());
//        call.enqueue(new Callback<Mess>() {
//            @Override
//            public void onResponse(Call<Mess>call, Response<Mess> response) {
//                Mess NewMess = response.body();
//
//                Toast.makeText(context.getApplicationContext(), "switch updated : "+NewMess.getId()+","+NewMess.getName()+", "+NewMess.getIs_on().toString(), Toast.LENGTH_SHORT).show();
//
//                Log.d(TAG, "Number of switches received: " +"with ID :" );
//            }
//
//            @Override
//            public void onFailure(Call<Mess>call, Throwable t) {
//                // Log error here since request failed
//                Log.e(TAG, t.toString());
//                Toast.makeText(context.getApplicationContext(), "something wrong happened, cant make the new switch", Toast.LENGTH_LONG).show();
//            }
//        });
//
//    }
}
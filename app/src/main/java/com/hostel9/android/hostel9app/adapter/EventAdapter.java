package com.hostel9.android.hostel9app.adapter;

/**
 * Created by akash on 04-Dec-17.
 */


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hostel9.android.hostel9app.R;
import com.hostel9.android.hostel9app.database.DatabaseHelper;
import com.hostel9.android.hostel9app.model.Event;

import java.util.List;


public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    private List<Event> Event;
    private int rowLayout;
    private Context context;
    private final String TAG = "Updating the event";
    DatabaseHelper db;


    public static class EventViewHolder extends RecyclerView.ViewHolder {
        LinearLayout EventLayout;
        TextView name;
        TextView genre;
        TextView description;
        TextView venue;
        TextView date;
        TextView time;
        



        public EventViewHolder(View v) {
            super(v);
            EventLayout = (LinearLayout) v.findViewById(R.id.EventList);
            name = (TextView) v.findViewById(R.id.name);
            genre = (TextView) v.findViewById(R.id.genre);
            description = (TextView) v.findViewById(R.id.description);
            venue = (TextView) v.findViewById(R.id.venue);
            date = (TextView) v.findViewById(R.id.date);
            time = (TextView) v.findViewById(R.id.time);

        }
    }

    public EventAdapter(List<Event> Event, int rowLayout, Context context) {
        this.Event = Event;
        this.rowLayout = rowLayout;
        this.context = context;
        db = new DatabaseHelper(context);
    }

    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new EventViewHolder(view);
    }


    @Override
    public void onBindViewHolder(EventViewHolder holder, final int position) {
        holder.name.setText(Event.get(position).getName());
        holder.genre.setText(Event.get(position).getGenre());
        holder.description.setText(Event.get(position).getDescription());
        holder.venue.setText(Event.get(position).getVenue());
        holder.date.setText(Event.get(position).getDate());
        holder.time.setText(Event.get(position).getTime());


    }

    @Override
    public int getItemCount() {
        return Event.size();
    }
}
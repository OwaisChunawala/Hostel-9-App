package com.hostel9.android.hostel9app.adapter;

/**
 * Created by akash on 04-Dec-17.
 */


import android.content.Context;
import android.content.res.ColorStateList;
import android.support.transition.TransitionManager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
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
    private RecyclerView recyclerView;
    private final String TAG = "Updating the event";
    DatabaseHelper db;
    int mExpandedPosition = -1;


    public static class EventViewHolder extends RecyclerView.ViewHolder {
        LinearLayout EventLayout;
        TextView name;
        TextView genre;
        TextView description;
        TextView venue;
        TextView date;
        TextView time;
        CardView cardView;
        ImageView imageView;

        



        public EventViewHolder(View v) {
            super(v);
            EventLayout = (LinearLayout) v.findViewById(R.id.EventList);
            name = (TextView) v.findViewById(R.id.name);
            genre = (TextView) v.findViewById(R.id.genre);
            description = (TextView) v.findViewById(R.id.description);
            venue = (TextView) v.findViewById(R.id.venue);
            date = (TextView) v.findViewById(R.id.date);
            time = (TextView) v.findViewById(R.id.time);
            cardView = (CardView) v.findViewById(R.id.replacer_icon);
            imageView = (ImageView) v.findViewById(R.id.replacer_image);


        }
    }

    public EventAdapter(List<Event> Event, int rowLayout, RecyclerView recyclerView, Context context) {
        this.Event = Event;
        this.rowLayout = rowLayout;
        this.context = context;
        this.recyclerView = recyclerView;
        db = new DatabaseHelper(context);
    }

    @Override
    public EventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new EventViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final EventViewHolder holder, final int position) {

        String genre1 = Event.get(position).getGenre();
        if("sports".equals(genre1)){
            holder.imageView.setImageResource(R.drawable.event_sports_icon);
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorGreen));
        }
        if("tech".equals(genre1)){
            holder.imageView.setImageResource(R.drawable.event_tech_icon);
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorAccent));
        }
        if("cult".equals(genre1)){
            holder.imageView.setImageResource(R.drawable.event_cult_icon);
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorYellow));
        }
        if("general".equals(genre1)){
            holder.imageView.setImageResource(R.drawable.event_general_icon);
            holder.cardView.setCardBackgroundColor(context.getResources().getColor(R.color.colorOrange));
        }
        holder.name.setText(Event.get(position).getName());
        holder.genre.setText(Event.get(position).getGenre());
        holder.description.setText(Event.get(position).getDescription());
        holder.venue.setText(Event.get(position).getVenue());
        holder.date.setText(Event.get(position).getDate());
        holder.time.setText(Event.get(position).getTime());


        final boolean isExpanded = position==mExpandedPosition;
        holder.description.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                TransitionManager.beginDelayedTransition(recyclerView);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return Event.size();
    }
}
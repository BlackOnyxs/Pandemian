package com.dark_tech.pandemian.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.pojo.Location;

import java.util.ArrayList;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.HospitalViewHolder> {

    private ArrayList<Location> locations;
    private HospitalClickLister listener;
    private Context context;

    public HospitalAdapter(ArrayList<Location> locations, HospitalClickLister listener, Context context) {
        this.locations = locations;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public HospitalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hospital, parent, false);
        return new HospitalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalViewHolder holder, int position) {
        Location lo = locations.get(position);

        if (lo.getName() != null){
            holder.tvName.setText(lo.getName());
        }

        holder.onClick(lo, listener);
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    public void add(Location location){
        if (!locations.contains(location)){
            locations.add(location);
            notifyItemInserted(locations.size()-1);
        }
    }
    static class HospitalViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView tvName;
        private View view;
        public HospitalViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            view = itemView;
        }
        void onClick(final Location location, final HospitalClickLister listener){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(location);
                }
            });
        }
    }
}

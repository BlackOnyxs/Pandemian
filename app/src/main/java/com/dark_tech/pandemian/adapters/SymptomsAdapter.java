package com.dark_tech.pandemian.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.pojo.Symptom;

import java.util.ArrayList;

public class SymptomsAdapter extends RecyclerView.Adapter<SymptomsAdapter.SymptomsViewHolder> {

    private ArrayList<Symptom> symptoms;
    private SymptomsClickLister listener;
    private Context context;

    public SymptomsAdapter(ArrayList<Symptom> symptoms, SymptomsClickLister listener, Context context) {
        this.symptoms = symptoms;
        this.listener = listener;
        this.context = context;
    }

    @NonNull
    @Override
    public SymptomsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_symptoms, parent, false);
        return new SymptomsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SymptomsViewHolder holder, int position) {
        Symptom symptom = symptoms.get(position);

        if (symptom.getName() != null){
            holder.cbName.setText(symptom.getName());
        }

        holder.onClick(symptom, listener);
    }

    @Override
    public int getItemCount() {
        return symptoms.size();
    }

    public void add(Symptom symptom){
        if (!symptoms.contains(symptom)){
            symptoms.add(symptom);
            notifyItemInserted(symptoms.size()-1);
        }
    }
    static class SymptomsViewHolder extends RecyclerView.ViewHolder {
        private CheckBox cbName;
        private View view;
        public SymptomsViewHolder(@NonNull View itemView) {
            super(itemView);
            cbName = itemView.findViewById(R.id.cbName);
            view = itemView;
        }
        void onClick(final Symptom symptom, final SymptomsClickLister listener){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(symptom);
                }
            });
        }
    }
}

package com.dark_tech.pandemian.vaccine;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dark_tech.pandemian.R;


public class DetailFragment extends Fragment {
    private int vaccineType;

    public DetailFragment(int vaccine){
         vaccineType = vaccine;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        TextView tvName = view.findViewById(R.id.tvName);
        TextView tvBrand = view.findViewById(R.id.tvBrand);
        TextView tvType = view.findViewById(R.id.tvVaccineType);
        TextView tvCant = view.findViewById(R.id.tvCant);
        TextView tvSupply = view.findViewById(R.id.tvSupply);
        TextView tvNotContent = view.findViewById(R.id.tvNotContent);
        TextView tvSuggest = view.findViewById(R.id.tvSuggest);
        TextView tvNotSuggest = view.findViewById(R.id.tvNotSuggest);
        TextView tvEffects = view.findViewById(R.id.tvEffects);

        //TODO: Load Brand Data by id and set data to the view

        return view;
    }
}
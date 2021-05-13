package com.dark_tech.pandemian.vaccine;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dark_tech.pandemian.R;

public class VaccineFragment extends Fragment implements View.OnClickListener {

    private int vaccineType;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_vaccine, container, false);
        Button btnPfi = view.findViewById(R.id.btn_pfitzer);
        Button btnAstra = view.findViewById(R.id.btn_astra);
        Button btnModern = view.findViewById(R.id.btn_modern);

        btnPfi.setOnClickListener(this);
        btnAstra.setOnClickListener(this);
        btnModern.setOnClickListener(this);

        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId() ){
            case R.id.btn_astra:
                vaccineType = 0;
                break;
            case R.id.btn_pfitzer:
                vaccineType = 1;
                break;
            case R.id.btn_modern:
                vaccineType = 2;
                break;
        }
        DetailFragment fragment = new DetailFragment(vaccineType);
        loadFragment( fragment );
    }
    private void loadFragment(Fragment currentFragment) {
        if (currentFragment != null){
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, currentFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }
}
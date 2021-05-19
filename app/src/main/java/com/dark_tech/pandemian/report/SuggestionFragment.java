package com.dark_tech.pandemian.report;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.ReportSingleton;

public class SuggestionFragment extends Fragment {

    private Fragment fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Si esta vacunado y si se quiere vacunar
        View view = inflater.inflate(R.layout.fragment_suggestion, container, false);
        Button btn_next = view.findViewById(R.id.btn_next);
        final RadioButton rbNo = view.findViewById(R.id.rbNo);
        final RadioButton rbYes2 = view.findViewById(R.id.rbYes2);
        RadioButton rbNo2 = view.findViewById(R.id.rbNo2);
        final ReportSingleton reportSingleton = ReportSingleton.getInstance();


        if ( rbNo.isChecked() ){
            rbYes2.setEnabled(true);
            rbNo2.setEnabled(true);
        }

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reportSingleton.getReport().setVaccineStatus(rbNo.isChecked());
                reportSingleton.getReport().setVaccineInterest(rbYes2.isChecked());
                if ( rbYes2.isChecked() ){
                    fragment = new VaccineWebFragment();
                }else{
                    fragment = new PersonalFragment();
                }
                loadFragment( fragment );

            }
        });
        return view;
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
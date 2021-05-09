package com.dark_tech.pandemian.report;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;

import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.ReportSingleton;
import com.dark_tech.pandemian.pojo.Report;

public class GenderFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {

    private AppCompatTextView tvAge;
    private static final String SEX_MALE = "Masculino";
    private static final String SEX_FEMALE = "Femenino";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grender, container, false);
        Button btn = view.findViewById(R.id.btn_next);
        AppCompatSeekBar sbAge = view.findViewById(R.id.seekAge);
        final RadioButton rbMale = view.findViewById(R.id.rbMale);
        final RadioButton rbFemale = view.findViewById(R.id.rbFemale);
        tvAge = view.findViewById(R.id.tvAge);

        sbAge.setOnSeekBarChangeListener( this );

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReportSingleton singleton = ReportSingleton.getInstance();
                Report report = new Report();

                if (rbMale.isChecked()){
                    report.setSex(SEX_MALE);
                }else if(rbFemale.isChecked()){
                    report.setSex(SEX_FEMALE);
                }
                report.setAge(tvAge.getText().toString());
                singleton.setReport(report);

                LocationFragment fragment = new LocationFragment();
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

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        tvAge.setText(String.valueOf(progress));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
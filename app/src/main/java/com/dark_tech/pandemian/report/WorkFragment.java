package com.dark_tech.pandemian.report;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.ReportSingleton;
import com.dark_tech.pandemian.utils.Utils;


public class WorkFragment extends Fragment {

    // Si trabaja

    private static final String WORK_LAB = "Laborando";
    private static final String WORK_SUS = "Suspendido";
    private static final String WORK_UM = "Desempleado";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_work, container, false);
        RadioButton rbLab = view.findViewById(R.id.rbLab);
        RadioButton rbSus = view.findViewById(R.id.rbSus);
        RadioButton rbUn = view.findViewById(R.id.rbUnemployed);
        final AppCompatEditText edtWork = view.findViewById(R.id.edtName);
        final ReportSingleton singleton = ReportSingleton.getInstance();
        Button btnNext = view.findViewById(R.id.btn_next);


        if ( rbLab.isChecked() ) {
            edtWork.setEnabled( true );
            singleton.getReport().setWorkStatus( WORK_LAB );
        }else if ( rbSus.isChecked() ){
            singleton.getReport().setWorkStatus( WORK_SUS );
        }else if (rbUn.isChecked() ) {
            singleton.getReport().setWorkStatus( WORK_UM );
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Utils.verifiedField( edtWork, getContext() )){
                    singleton.getReport().setWorkName( edtWork.getText().toString().trim());
                }
                HelpFragment fragment = new HelpFragment();
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
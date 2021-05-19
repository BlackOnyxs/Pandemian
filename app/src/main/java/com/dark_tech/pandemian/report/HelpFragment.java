package com.dark_tech.pandemian.report;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.ReportSingleton;

public class HelpFragment extends Fragment {
    // Si recibe ayuda del gobierno y el tipo de ayuda

    private static final String HELP_YES = "Sí";
    private static final String HELP_SOMETIMES = "Aveces";
    private static final String HELP_NEVER = "Nunca";

    private static final String HELP_VALE = "Vale";
    private static final String HELP_BACK = "Bolsas";
    private static final String HELP_CARD = "Tarjeta";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_help, container, false);

        Button btnNext = view.findViewById(R.id.btn_next);
        final RadioButton rbYes = view.findViewById(R.id.rbYes);
        final RadioButton rbSometime = view.findViewById(R.id.rbSometime);
        RadioButton rbNever = view.findViewById(R.id.rbNever);
//        RadioGroup rg= view.findViewById(R.id.rgHelpType);


        final RadioButton rbVale = view.findViewById(R.id.rbVale);
        final RadioButton rbBack = view.findViewById(R.id.rbBack);
        final RadioButton rbCard = view.findViewById(R.id.rbCard);

        final ReportSingleton reportSingleton = ReportSingleton.getInstance();

        rbNever.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbBack.setEnabled( false );
                rbVale.setEnabled( false );
                rbCard.setEnabled( false );

                reportSingleton.getReport().setHelp(HELP_NEVER);
            }
        });
        rbYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbBack.setEnabled( true );
                rbVale.setEnabled( true );
                rbCard.setEnabled( true );

                reportSingleton.getReport().setHelp(HELP_NEVER);
            }
        });
        rbSometime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rbBack.setEnabled( true );
                rbVale.setEnabled( true );
                rbCard.setEnabled( true );

            }
        });

      if ( rbYes.isChecked() ){
            reportSingleton.getReport().setHelp(HELP_YES);
        }else if ( rbSometime.isChecked() ){
            reportSingleton.getReport().setHelp(HELP_SOMETIMES);
        }

        if ( rbYes.isChecked() || rbSometime.isChecked() ){
            if ( rbVale.isChecked() ){
                reportSingleton.getReport().setHelpType(HELP_VALE);
            }else if ( rbBack.isChecked() ){
                reportSingleton.getReport().setHelpType(HELP_BACK);
            }else if ( rbCard.isChecked() ){
                reportSingleton.getReport().setHelpType(HELP_CARD);
            }
        }

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SymptomFragment fragment = new SymptomFragment();
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
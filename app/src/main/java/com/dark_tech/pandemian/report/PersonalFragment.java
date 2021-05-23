package com.dark_tech.pandemian.report;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.ReportSingleton;
import com.dark_tech.pandemian.pojo.Report;
import com.dark_tech.pandemian.utils.Utils;

public class PersonalFragment extends Fragment {
// Nombre y cedula

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_personal, container, false);
        Button btn = view.findViewById(R.id.btn_next);
        final AppCompatEditText edtName = view.findViewById(R.id.edtName);
        final AppCompatEditText edtCip = view.findViewById(R.id.edtCid);
        final AppCompatEditText edtPhone = view.findViewById(R.id.edtPhone);

        final ReportSingleton reportSingleton = ReportSingleton.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( Utils.verifiedField(edtName, getContext()) && Utils.verifiedField(edtCip,getContext()) && Utils.verifiedField(edtPhone,getContext())){
                    Report report = new Report();
                    report.setName(edtName.getText().toString().trim());
                    report.setCip(edtCip.getText().toString().trim());
                    report.setPhone(edtPhone.getText().toString().trim());
                    reportSingleton.setReport(report);
                    GenderFragment fragment = new GenderFragment();
                    loadFragment( fragment );
                }
            }
        });
        return view;
    }

    private boolean loadFragment(Fragment currentFragment) {
        if (currentFragment != null){
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, currentFragment)
                    .addToBackStack(null)
                    .commit();
        }
        return false;
    }
}
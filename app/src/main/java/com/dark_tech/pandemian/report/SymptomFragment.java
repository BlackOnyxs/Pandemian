package com.dark_tech.pandemian.report;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.ReportSingleton;
import com.dark_tech.pandemian.adapters.SymptomsAdapter;
import com.dark_tech.pandemian.adapters.SymptomsClickLister;
import com.dark_tech.pandemian.pojo.Report;
import com.dark_tech.pandemian.pojo.Symptom;
import com.dark_tech.pandemian.utils.Utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class SymptomFragment extends Fragment implements SymptomsClickLister {

    private SymptomsAdapter mSymptomsAdapter;
    private RecyclerView mRvSymptoms;
    private Button mBtnSubmit;
    private ReportSingleton singleton;
    private ProgressBar mPb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_symptom, container, false);


        mRvSymptoms = view.findViewById(R.id.rvSymptoms);
        mBtnSubmit = view.findViewById(R.id.btnNext);
        mPb = view.findViewById(R.id.pb);
        configRv();

        singleton = ReportSingleton.getInstance();

        for (Symptom s:
                Utils.getSymptoms()) {
            mSymptomsAdapter.add(s);
        }

        mBtnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPb.setVisibility(View.VISIBLE);
                if (singleton.getReport() != null){
                    singleton.getReport().setSymptoms(new ArrayList<Symptom>());
                }
                singleton.getReport().setSymptoms(Utils.getSymptoms());
                singleton.getReport().setDate(getCurrentDate());
                mPb.setVisibility(View.GONE);
                SuggestionFragment fragment = new SuggestionFragment();
                loadFragment( fragment );
            }
        });
        return view;
    }

    private void configRv(){
        mSymptomsAdapter = new SymptomsAdapter(new ArrayList<Symptom>(), this, getContext());
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        mRvSymptoms.setAdapter(mSymptomsAdapter);
        mRvSymptoms.setLayoutManager(manager);
    }

    private String getCurrentDate(){
//        Log.i("Date", "Is Finished");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-5"));
        Date today = Calendar.getInstance().getTime();
//        Log.i("Date", dateFormat.format(today));
        return dateFormat.format(today);
    }


    @Override
    public void onClick(Symptom symptom) {
        new AlertDialog.Builder(getContext())
                .setTitle(symptom.getName())
                .setMessage(symptom.getDescription())
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
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
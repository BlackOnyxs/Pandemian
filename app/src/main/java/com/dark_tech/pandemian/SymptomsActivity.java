package com.dark_tech.pandemian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dark_tech.pandemian.adapters.SymptomsAdapter;
import com.dark_tech.pandemian.adapters.SymptomsClickLister;
import com.dark_tech.pandemian.pojo.Report;
import com.dark_tech.pandemian.pojo.Symptom;
import com.dark_tech.pandemian.utils.Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class SymptomsActivity extends AppCompatActivity implements SymptomsClickLister {
    private SymptomsAdapter mSymptomsAdapter;
    private RecyclerView mRvSymptoms;
    private Button mBtnSubmit;
    private ReportSingleton singleton;
    private ProgressBar mPb;
    private boolean success;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        mRvSymptoms = findViewById(R.id.rvSymptoms);
        mBtnSubmit = findViewById(R.id.btnNext);
        mPb = findViewById(R.id.pb);
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
                   if (uploadReport(singleton.getReport())){
                       Toast.makeText(getApplicationContext(), "Enviado", Toast.LENGTH_LONG).show();
                   }else{
                       Toast.makeText(getApplicationContext(), "Error al enviar.", Toast.LENGTH_LONG).show();
                   }
                   mPb.setVisibility(View.GONE);

            }
        });
    }

    private void configRv(){
        mSymptomsAdapter = new SymptomsAdapter(new ArrayList<Symptom>(), this, getApplicationContext());
        LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext());
        mRvSymptoms.setAdapter(mSymptomsAdapter);
        mRvSymptoms.setLayoutManager(manager);
    }

    @Override
    public void onClick(Symptom symptom) {
        new AlertDialog.Builder(this)
                .setTitle(symptom.getName())
                .setMessage(symptom.getDescription())
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create().show();
    }
      private String getCurrentDate(){
//        Log.i("Date", "Is Finished");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, ''yy");
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT-5"));
        Date today = Calendar.getInstance().getTime();
//        Log.i("Date", dateFormat.format(today));
        return dateFormat.format(today);
    }

    private boolean uploadReport(Report report) {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference reference = db.getReference();

        reference.child("report").push().setValue(report).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                success = true;
            }
        });
        return success;
    }
}

package com.dark_tech.pandemian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;

import com.dark_tech.pandemian.pojo.Report;
import com.dark_tech.pandemian.utils.Utils;

public class PatientActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private AppCompatEditText edtName, edtCid;
    private AppCompatTextView tvAge;
    private RadioButton rbMale, rbFemale;
    private AppCompatSeekBar sbAge;
    private Button btnNext;

    private static final String SEX_MALE = "Masculino";
    private static final String SEX_FEMALE = "Femenino";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);

        tvAge = findViewById(R.id.tvAge);
        edtName = findViewById(R.id.edtName);
        edtCid = findViewById(R.id.edtCid);
        rbMale = findViewById(R.id.rbMale);
        rbFemale = findViewById(R.id.rbFemale);
        sbAge = findViewById(R.id.seekAge);
        btnNext = findViewById(R.id.btnNext);

        sbAge.setProgress(18);
        tvAge.setText(String.valueOf(sbAge.getProgress()));

        sbAge.setOnSeekBarChangeListener(this);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReportSingleton singleton = ReportSingleton.getInstance();
                Report report = new Report();

                if (Utils.verifyReport(edtName, edtCid, getApplicationContext())){
                    report.setName(edtName.getText().toString().trim());
                    report.setCid(edtCid.getText().toString().trim());

                    if (rbMale.isChecked()){
                        report.setSex(SEX_MALE);
                    }else if(rbFemale.isChecked()){
                        report.setSex(SEX_FEMALE);
                    }
                    report.setAge(tvAge.getText().toString());
                    singleton.setReport(report);

                    Intent intent = new Intent(PatientActivity.this, SymptomsActivity.class);
                    startActivity(intent);
                }
            }
        });

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

package com.dark_tech.pandemian.utils;

import android.content.Context;

import androidx.appcompat.widget.AppCompatEditText;

import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.pojo.LatLng;
import com.dark_tech.pandemian.pojo.Location;
import com.dark_tech.pandemian.pojo.Symptom;

import java.util.ArrayList;

public class Utils {
/*    public static boolean verifyReport(AppCompatEditText edtName, AppCompatEditText edtCid, Context context){
        boolean isValid = true;
        if (edtName.getText().toString().trim().isEmpty()){
            edtName.setError(context.getString(R.string.data_required_error));
            isValid = false;
        }
        if (edtCid.getText().toString().trim().isEmpty()){
            edtCid.setError(context.getString(R.string.data_required_error));
            isValid = false;
        }
        return isValid;
    }
    */

    public static boolean verifiedField( AppCompatEditText edt, Context context ) {
        boolean isValid = true;
        if ( edt.getText().toString().trim().isEmpty() ) {
            edt.setError(context.getString(R.string.data_required_error));
            isValid = false;
        }

        return isValid;
    }

    public static ArrayList<Symptom> getSymptoms(){
        ArrayList<Symptom> symptoms = new ArrayList<>();

        Symptom fever = new Symptom("Fiebre", "Some description");
        Symptom dryCough = new Symptom("Tos Seca", "Some description");
        Symptom fatigue = new Symptom("Cansancio", "Some description");
        Symptom aches = new Symptom("Molestias y dolores", "Some description");
        Symptom throat = new Symptom("Dolor de garganta", "Some description");
        Symptom diarrhea = new Symptom("Diarrea", "Some description");

        symptoms.add(fever);
        symptoms.add(dryCough);
        symptoms.add(fatigue);
        symptoms.add(aches);
        symptoms.add(throat);
        symptoms.add(diarrhea);

        return symptoms;
    }

//    public static ArrayList<Location> getHospitals(){
//        ArrayList<Location> locations = new ArrayList<>();
//
//        Location c = new Location();
//        c.setNickName("Luis 'Chicho' Fábrega");
//        c.setAbout("Some description");
//        c.setLocation(new LatLng(8.077881, -80.931284));
//
//        Location d = new Location();
//        d.setNickName("Columbia");
//        d.setAbout("Some description");
//        d.setLocation(new LatLng(8.077881, -80.931284));
//
//        Location e = new Location();
//        e.setNickName("Example");
//        e.setAbout("Some description");
//        e.setLocation(new LatLng(8.077881, -80.931284));
//
//        locations.add(c);
//        locations.add(d);
//        locations.add(e);
//
//        return locations;
//    }
}

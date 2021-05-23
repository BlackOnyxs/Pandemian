package com.dark_tech.pandemian.vaccine;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dark_tech.pandemian.R;
import com.dark_tech.pandemian.pojo.Vaccine;
import com.dark_tech.pandemian.report.VaccineWebFragment;


public class DetailFragment extends Fragment {
    private int vaccineType;

    public DetailFragment(int vaccine){
         vaccineType = vaccine;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_detail, container, false);
        ImageView ivTitle = view.findViewById(R.id.img_title);
        TextView tvName = view.findViewById(R.id.tvNameTitle);
        TextView tvBrand = view.findViewById(R.id.tvBrandTitle);
        TextView tvType = view.findViewById(R.id.tvVaccineTypeTitle);
        TextView tvCant = view.findViewById(R.id.tvCantTitle);
        TextView tvSupply = view.findViewById(R.id.tvSupplyTitle);
        TextView tvNotContent = view.findViewById(R.id.tvNotContentTitle);
        TextView tvSuggest = view.findViewById(R.id.tvSuggestTitle);
        TextView tvNotSuggest = view.findViewById(R.id.tvNotSuggestTitle);
        TextView tvEffects = view.findViewById(R.id.tvEffectsTitle);
        TextView tvRef = view.findViewById(R.id.tvRef);
        TextView tvInterest = view.findViewById(R.id.tvInterest);
        //TODO: Load Brand Data by id and set data to the view
       if ( selectVaccine() != null ) {
           final Vaccine currentVaccine = selectVaccine();
           ivTitle.setImageDrawable(currentVaccine.getImg());
           tvName.setText(getContext().getString(R.string.vaccine_name, currentVaccine.getName()));
           tvBrand.setText(getContext().getString(R.string.vaccine_brand,currentVaccine.getBrand()));
           tvType.setText(getContext().getString(R.string.vaccine_type, currentVaccine.getType()));
           tvCant.setText(getContext().getString(R.string.vaccine_cant, currentVaccine.getCant()));
           tvSupply.setText(getContext().getString(R.string.vaccine_supply, currentVaccine.getSupply()));
           tvNotContent.setText(getContext().getString(R.string.vaccine_notContent,currentVaccine.getNotContent()));
           tvSuggest.setText(getContext().getString(R.string.vaccine_suggest, currentVaccine.getSuggest()));
           tvNotSuggest.setText(getContext().getString(R.string.vaccine_notSuggest, currentVaccine.getNotSuggest()));
           tvEffects.setText(getContext().getString(R.string.vaccine_effects, currentVaccine.getEffects()));
           tvRef.setText(getContext().getString(R.string.vaccine_ref, currentVaccine.getRef()));

           tvRef.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   VaccineWebFragment fragment = new VaccineWebFragment(currentVaccine.getRefLink());
                   loadFragment( fragment );
               }
           });
           tvInterest.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   VaccineWebFragment fragment = new VaccineWebFragment("https://www.panamasolidario.gob.pa/pag/vacunas");
                   loadFragment( fragment );
               }
           });
       }

        return view;
    }

    private Vaccine selectVaccine(){
        Vaccine currentVaccine = null;
        switch (vaccineType){
            case 0:
                currentVaccine = loadAztra();
                break;
            case 1:
                currentVaccine = loadPfitzer();
                break;
        }

        return currentVaccine;
    }

    private void loadFragment(Fragment currentFragment) {
        if (currentFragment != null){
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, currentFragment)
                    .addToBackStack(null)
                    .commit();
        }
    }

    public Vaccine loadPfitzer(){
        Vaccine pfitzer = new Vaccine();
        pfitzer.setBrand("Pfitzer");
        pfitzer.setName("BNT162b2");
        pfitzer.setType("mRNA");
        pfitzer.setCant("2 dosis con 21 días de diferencia");
        pfitzer.setSupply("inyección en el músculo de la parte superior del brazo");
        pfitzer.setNotContent(" huevos, conservantes, látex");
        pfitzer.setSuggest("La vacuna de Pfizer-BioNTech se recomienda para personas de 16 años o más.");
        pfitzer.setNotSuggest("Si ha tenido una reacción alérgica grave (anafilaxia) o una reacción alérgica inmediata, aunque no sea grave:\n" +
                "a alguno de los ingredientes de la vacuna ARNm contra el COVID-19 (como el polietilenglicol), no debería administrarse la vacuna ARNm contra el COVID-19*.\n" +
                "tras recibir la primera dosis de la vacuna, no debería recibir la segunda dosis de ninguna de las vacunas ARNm contra el COVID-19.\n");
        pfitzer.setEffects("Cansancio, Dolor de cabeza, Dolor muscular, Escalofríos, Fiebre, Náuseas.");
        pfitzer.setRef("Centro Nacional de Vacunación y Enfermedades Respiratorias.");
        pfitzer.setRefLink("https://espanol.cdc.gov/coronavirus/2019-ncov/vaccines/different-vaccines.html");
        pfitzer.setImg(getContext().getDrawable(R.drawable.pfitzer));
        return pfitzer;
    }
    public Vaccine loadAztra(){
        Vaccine aztra = new Vaccine();
        aztra.setBrand("ModernaTX, Inc.");
        aztra.setName("mRNA-1273");
        aztra.setType("mRNA");
        aztra.setCant("2 dosis con 28 días de diferencia");
        aztra.setSupply("inyección en el músculo de la parte superior del brazo");
        aztra.setNotContent(" huevos, conservantes, látex");
        aztra.setSuggest("La vacuna de Pfizer-BioNTech se recomienda para personas de 18 años o más.");
        aztra.setNotSuggest("Si ha tenido una reacción alérgica grave (anafilaxia) o una reacción alérgica inmediata, aunque no sea grave:\n" +
                "a alguno de los ingredientes de la vacuna ARNm contra el COVID-19 (como el polietilenglicol), no debería administrarse la vacuna ARNm contra el COVID-19*.\n" +
                "tras recibir la primera dosis de la vacuna, no debería recibir la segunda dosis de ninguna de las vacunas ARNm contra el COVID-19.\n");
        aztra.setEffects("Cansancio, Dolor de cabeza, Dolor muscular, Escalofríos, Fiebre, Náuseas.");
        aztra.setRef("Centro Nacional de Vacunación y Enfermedades Respiratorias.");
        aztra.setRefLink("https://espanol.cdc.gov/coronavirus/2019-ncov/vaccines/different-vaccines.html");
        aztra.setImg(getContext().getDrawable(R.drawable.astrazeneca));
        return aztra;
    }

}
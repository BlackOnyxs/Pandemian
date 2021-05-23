package com.dark_tech.pandemian.report;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.dark_tech.pandemian.R;


public class VaccineWebFragment extends Fragment {
    private String currentUrl;

  public VaccineWebFragment(String url){
      currentUrl = url;
  }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vaccine_web, container, false);
        WebView web = view.findViewById(R.id.webVaccine);
        web.loadUrl(currentUrl);

        return view;
    }

}
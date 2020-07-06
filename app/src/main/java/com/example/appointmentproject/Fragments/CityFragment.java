package com.example.appointmentproject.Fragments;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.chivorn.smartmaterialspinner.SmartMaterialSpinner;
import com.example.appointmentproject.R;
import com.example.appointmentproject.adapters.Sehirler;


public class CityFragment extends Fragment {
    View view;
    SmartMaterialSpinner spinner_sehir;
    Sehirler sehirler=new Sehirler();
    Button kayit_ol;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_city, container, false);
        spinner_sehir=view.findViewById(R.id.spinner_sehir);
        spinner_sehir.setItem(sehirler.getSehirListesi());
        kayit_ol=view.findViewById(R.id.kayit_ol);




        kayit_ol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Toast.makeText(getActivity(),"basabildin",Toast.LENGTH_LONG).show();


            }
        });

        return view;
    }
}

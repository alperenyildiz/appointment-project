package com.example.appointmentproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appointmentproject.R;
import com.zigis.materialtextfield.MaterialTextField;



public class NameFragment extends Fragment {

    public static MaterialTextField name;
    public static MaterialTextField surname;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_name, container, false);

        name=view.findViewById(R.id.name);
        surname=view.findViewById(R.id.surname);





        return view;
    }
}

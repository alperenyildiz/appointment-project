package com.example.appointmentproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appointmentproject.R;

import br.com.sapereaude.maskedEditText.MaskedEditText;


public class PhoneFragment extends Fragment {

    public static MaskedEditText phone;
    View view;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_phone, container, false);
        phone=view.findViewById(R.id.phone);
        return view;

    }


}

package com.example.appointmentproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appointmentproject.R;
import com.zigis.materialtextfield.MaterialTextField;


/**
 * A simple {@link Fragment} subclass.
 */
public class MailFragment extends Fragment {

    public static MaterialTextField mail;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_mail, container, false);

        mail=view.findViewById(R.id.mail);
        return view;
    }
}

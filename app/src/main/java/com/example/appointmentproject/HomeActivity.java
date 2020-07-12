package com.example.appointmentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.mancj.materialsearchbar.MaterialSearchBar;
import com.zigis.materialtextfield.MaterialTextField;


public class HomeActivity extends AppCompatActivity{

    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        search=findViewById(R.id.search);



    }


    }
package com.example.appointmentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import com.fevziomurtekin.searchview.SearchView;

public class HomeActivity extends AppCompatActivity implements TextWatcher {

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchView=findViewById(R.id.search);

        searchView      = new SearchView(getApplicationContext());
        searchView      . setSearchView_hint("Search");
        searchView      . setSearchView_textSize(14f);
        searchView      . setSearchView_animationTime(250);
        searchView      . setSearchView_textColor(getResources().getColor(R.color.Blue_Ivy));
        searchView      . setResult_textSize(14f);
        searchView      . setResult_textColor(getResources().getColor(R.color.Blue_Ivy));

    }


    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}
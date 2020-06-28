package com.example.appointmentproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.appointmentproject.R;
import com.zigis.materialtextfield.MaterialTextField;


public class PasswordFragment extends Fragment {

    View view;
    MaterialTextField password,confirm_password;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_password, container, false);
        password=view.findViewById(R.id.password);
        confirm_password=view.findViewById(R.id.confirm_password);
        passwordShow();
        return view;
    }


    public void passwordShow(){
        confirm_password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (confirm_password.getRight() - confirm_password.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {

                        if(confirm_password.getTransformationMethod()==null){
                            confirm_password.setTransformationMethod(new PasswordTransformationMethod());
                            confirm_password.setSelection(confirm_password.getText().length());
                            confirm_password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.password,0,R.drawable.ic_password_eye, 0);
                        }else{
                            confirm_password.setTransformationMethod(null);
                            confirm_password.setSelection(confirm_password.getText().length());
                            confirm_password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.password,0,R.drawable.ic_close_eye,0);
                        }

                        return true;
                    }
                }
                return false;
            }
        });

        password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (password.getRight() - password.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {

                        if(password.getTransformationMethod()==null){
                            password.setTransformationMethod(new PasswordTransformationMethod());
                            password.setSelection(password.getText().length());
                            password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.password,0,R.drawable.ic_password_eye, 0);
                        }else{
                            password.setTransformationMethod(null);
                            password.setSelection(password.getText().length());
                            password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.password,0,R.drawable.ic_close_eye,0);
                        }

                        return true;
                    }
                }
                return false;
            }
        });
    }

}

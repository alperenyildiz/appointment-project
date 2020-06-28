package com.example.appointmentproject;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.zigis.materialtextfield.MaterialTextField;

public class LoginFragment extends Fragment {
    Handler handler= new Handler();
    View view;
    TextView forgot_password;
    MaterialTextField login_email;
    MaterialTextField login_password;
    Button login_button;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.login_fragment, container, false);
        //Tanımlamalar Başlangıç
        forgot_password=view.findViewById(R.id.forgot_password);
        login_email=view.findViewById(R.id.login_email);
        login_password=view.findViewById(R.id.login_password);
        login_button=view.findViewById(R.id.login_button);
        //Tanımlamalar Bitiş
        passwordShow();


        forgot_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Bounce).playOn(view.findViewById(R.id.forgot_password));

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sifreHatirlatmaDialogOlustur();
                    }

                },500);
            }
        });



        return view;
    }







    public void sifreHatirlatmaDialogOlustur(){
        final NiftyDialogBuilder dialogBuilder= NiftyDialogBuilder.getInstance(getActivity());
        dialogBuilder
                .withTitle("Şifre Hatırlatma")
                .withTitleColor("#FFFFFF")
                .withIcon(R.drawable.help_icon)
                .withDividerColor("#11000000")
                .withDialogColor("#F88158")
                .withMessage("Şifresini sıfırlamak istediğiniz hesabın kayıtlı olduğu mail adresini giriniz..")
                .isCancelableOnTouchOutside(false)
                .isCancelable(false)
                .setCustomView(R.layout.activity_forgot_password,getActivity())
                .withDuration(700)
                .withButton2Text("Vazgeç")
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.dismiss();
                    }
                })
                .withButton1Text("Gönder")
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView gelen=dialogBuilder.findViewById(R.id.forgot_email);
                        String gelen_mail=gelen.getText().toString();
                        if(gelen_mail.equals("")){
                            Toast.makeText(getActivity(), "Boş bırakmayınız", Toast.LENGTH_SHORT).show();
                        }else Toast.makeText(getActivity(), "Alınan Mail:"+gelen_mail, Toast.LENGTH_SHORT).show();
                    }
                })
                .withEffect(Effectstype.Shake)
                .show();


    }

    public void passwordShow(){
        //Parolayı Görme Başlangıç
        login_password.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int DRAWABLE_RIGHT = 2;

                if(event.getAction() == MotionEvent.ACTION_UP) {
                    if(event.getRawX() >= (login_password.getRight() - login_password.getCompoundDrawables()[DRAWABLE_RIGHT].getBounds().width())) {

                        if(login_password.getTransformationMethod()==null){
                            login_password.setTransformationMethod(new PasswordTransformationMethod());
                            login_password.setSelection(login_password.getText().length());
                            login_password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.password,0,R.drawable.ic_password_eye, 0);
                        }else{
                            login_password.setTransformationMethod(null);
                            login_password.setSelection(login_password.getText().length());
                            login_password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.password,0,R.drawable.ic_close_eye,0);
                        }

                        return true;
                    }
                }
                return false;
            }
        });
        //Parolayı Görme Bitiş
    }



}

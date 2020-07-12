package com.example.appointmentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.zagum.switchicon.SwitchIconView;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import libs.mjn.scaletouchlistener.ScaleTouchListener;


public class SplashActivity extends AppCompatActivity {
    Button login_page;
    Button register_page;
    ImageView setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        login_page=findViewById(R.id.login_page);
        setting = findViewById(R.id.iconsetting);


        setting.setOnTouchListener(new ScaleTouchListener(config) {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ayarlar",Toast.LENGTH_LONG).show();
            }
        });

        login_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main=new Intent(SplashActivity.this,HomeActivity.class);
                main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                main.putExtra("gelen","login");
                startActivity(main);
                finish();
            }
        });
        register_page=findViewById(R.id.register_page);
        register_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main=new Intent(SplashActivity.this,MainActivity.class);
                main.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                main.putExtra("gelen","register");
                startActivity(main);
                finish();
            }
        });




    }


    public  void cikisDialogOlustur(){
        final NiftyDialogBuilder dialogBuilder= NiftyDialogBuilder.getInstance(this);
        dialogBuilder
                .withTitle("Çıkma Diyaloğu")
                .withTitleColor("#FFFFFF")
                .withDividerColor("#11000000")
                .withMessage("Çıkmak istediğinize emin misiniz?")
                .withMessageColor("#FFFFFFFF")
                .withDialogColor("#F88158")
                .isCancelableOnTouchOutside(false)
                .isCancelable(false)
                .withIcon(R.drawable.exit_icon)
                .withDuration(700)
                .withEffect(Effectstype.Shake)
                .withButton1Text("Evet")
                .withButton2Text("Hayır")
                .setButton1Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(1);
                    }
                })
                .setButton2Click(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialogBuilder.dismiss();
                    }
                })
                .show();
    }


    @Override
    public void onBackPressed() {
        cikisDialogOlustur();
    }

    ScaleTouchListener.Config config = new ScaleTouchListener.Config(150, 0.85f, 0.85f);

}

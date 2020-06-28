package com.example.appointmentproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;


public class SplashActivity extends AppCompatActivity {
    Button login_page;
    Button register_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        login_page=findViewById(R.id.login_page);
        login_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main=new Intent(SplashActivity.this,MainActivity.class);
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
}

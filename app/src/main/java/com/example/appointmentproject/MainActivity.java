package com.example.appointmentproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.example.appointmentproject.adapters.ViewAdapter;
import com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import libs.mjn.scaletouchlistener.ScaleTouchListener;


public class MainActivity extends AppCompatActivity {

    LinearLayout layout;
    SmartTabLayout tab_layout;
    ViewPager view_pager;
    ScaleTouchListener.Config config = new ScaleTouchListener.Config(150, 0.85f, 0.85f);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("saasdfgihjıdkofghjklş");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("TEST");
        /////////////////////////////////////////
        layout=findViewById(R.id.layout);
        tab_layout=findViewById(R.id.tab_layout);
        view_pager=findViewById(R.id.view_pager);
        ViewAdapter adapter=new ViewAdapter(getSupportFragmentManager());
        adapter.FragmentEkle(new LoginFragment(),"OTURUM AÇ");
        adapter.FragmentEkle(new RegisterFragment(),"KAYIT OL");
        view_pager.setAdapter(adapter);
        tab_layout.setViewPager(view_pager);
        ////////////////////////////////////////////
        Bundle extras =getIntent().getExtras();
        String gelen_deger=extras.getString("gelen");
        if(gelen_deger.equals("login")){
            view_pager.setCurrentItem(0);

        }else view_pager.setCurrentItem(1);
///////////////////////////////////////////////////////

        layout=findViewById(R.id.layout);
        tab_layout.setSelectedIndicatorColors(Color.parseColor("#4E387E"),Color.parseColor("#F88158"));

        Animation animation=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.downtoup);
        layout.startAnimation(animation);

        tab_layout.getTabAt(0).setOnTouchListener(new ScaleTouchListener(config) {
            @Override
            public void onClick(View v) {
                view_pager.setCurrentItem(0);
            }
        });
        tab_layout.getTabAt(1).setOnTouchListener(new ScaleTouchListener(config) {
            @Override
            public void onClick(View v) {
                view_pager.setCurrentItem(1);
            }
        });

    }

    @Override
    public void onBackPressed() {
        cikisDialogOlustur();

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
}

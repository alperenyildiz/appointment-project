package com.example.appointmentproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.VideoView;

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

    private VideoView videoBG;
    MediaPlayer mMediaPlayer;
    int mCurrentVideoPosition;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Hook up the VideoView to our UI.
        videoBG = (VideoView) findViewById(R.id.videoView);
        // Build your video Uri
        Uri uri = Uri.parse("android.resource://" // First start with this,
                + getPackageName() // then retrieve your package name,
                + "/" // add a slash,
                + R.raw.coffee); // and then finally add your video resource. Make sure it is stored
        // in the raw folder.

        // Set the new Uri to our VideoView
        videoBG.setVideoURI(uri);
        // Start the VideoView
        videoBG.start();

        // Set an OnPreparedListener for our VideoView. For more information about VideoViews,
        // check out the Android Docs: https://developer.android.com/reference/android/widget/VideoView.html
        videoBG.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mMediaPlayer = mediaPlayer;
                // We want our video to play over and over so we set looping to true.
                mMediaPlayer.setLooping(true);
                // We then seek to the current posistion if it has been set and play the video.
                if (mCurrentVideoPosition != 0) {
                    mMediaPlayer.seekTo(mCurrentVideoPosition);
                    mMediaPlayer.start();
                }
            }
        });



        /////////////////////////////////////////
        layout=findViewById(R.id.layout);
        tab_layout=findViewById(R.id.tab_layout);
        view_pager=findViewById(R.id.view_pager);
        ViewAdapter adapter=new ViewAdapter(getSupportFragmentManager());
        adapter.FragmentEkle(new LoginFragment(),"OTURUM AÇ");
        adapter.FragmentEkle(new RegisterFragment(),"ÜCRETSİZ KAYDOL");
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
        tab_layout.setSelectedIndicatorColors(Color.parseColor("#0A2E7A"),Color.parseColor("#FFFFFF"));

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
                .withTitle("Çıkış")
                .withTitleColor("#000000")
                .withDividerColor("#303030")
                .withMessage("Çıkmak istediğinize emin misiniz?")
                .withMessageColor("#FFFFFF")
                .withDialogColor("#606060")
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

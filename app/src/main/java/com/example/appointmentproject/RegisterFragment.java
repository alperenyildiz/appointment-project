package com.example.appointmentproject;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.appointmentproject.Fragments.BirthDateFragment;
import com.example.appointmentproject.Fragments.CityFragment;
import com.example.appointmentproject.Fragments.MailFragment;
import com.example.appointmentproject.Fragments.NameFragment;
import com.example.appointmentproject.Fragments.PasswordFragment;
import com.example.appointmentproject.Fragments.PhoneFragment;
import com.example.appointmentproject.adapters.NonSwipeableViewPager;
import com.example.appointmentproject.adapters.ViewAdapter;
import com.ogaclejapan.smarttablayout.SmartTabLayout;


public class RegisterFragment extends Fragment {

    View view;
    SmartTabLayout tab_rec;
    public static NonSwipeableViewPager view_pager_rec;
    ImageButton next;
    ImageButton previous;
    int sayfa = 0;
    LinearLayout previous_layout, next_layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.register_fragment, container, false);
        /////////////Tanımlamalar/////////////////////////////
        previous_layout = view.findViewById(R.id.previous_layout);
        next_layout = view.findViewById(R.id.next_layout);
        tab_rec = view.findViewById(R.id.tab_register);
        view_pager_rec = view.findViewById(R.id.view_pager_rec);
        next = view.findViewById(R.id.next);
        previous = view.findViewById(R.id.previous);
        /////////////////////////////////////////////////////
        visibleControl();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Shake).playOn(view.findViewById(R.id.next));
                if (view_pager_rec.getCurrentItem() == 0) {
                    if (NameFragment.name.getText().toString().equals("") ||
                            NameFragment.surname.getText().toString().equals("")) {
                        Toast.makeText(getActivity(), "Boş geçilemez!", Toast.LENGTH_LONG).show();
                    } else {
                        view_pager_rec.setCurrentItem(view_pager_rec.getCurrentItem() + 1);

                    }
                } else if (view_pager_rec.getCurrentItem() == 1) {
                    if (MailFragment.mail.getText().toString().equals("")) {
                        Toast.makeText(getActivity(), "mail boş geçilemez!", Toast.LENGTH_LONG).show();
                    } else {
                        view_pager_rec.setCurrentItem(view_pager_rec.getCurrentItem() + 1);
                    }
                } else if (view_pager_rec.getCurrentItem() == 2) {
                    if (PasswordFragment.password.getText().toString().equals("") || PasswordFragment.confirm_password.getText().toString().equals("")) {
                        Toast.makeText(getActivity(), "Parola boş geçilemez!", Toast.LENGTH_LONG).show();
                    } else if (!PasswordFragment.password.getText().toString().equals(PasswordFragment.confirm_password.getText().toString())) {
                        Toast.makeText(getActivity(), "Parolalar eşleşmiyor!", Toast.LENGTH_LONG).show();
                    } else view_pager_rec.setCurrentItem(view_pager_rec.getCurrentItem() + 1);

                } else if (view_pager_rec.getCurrentItem() == 3) {
                    if (PhoneFragment.phone.getText().toString().equals("+90 (_ _ _)  _ _ _  _ _  _ _")) {
                        Toast.makeText(getActivity(), "Telefon boş geçilemez!", Toast.LENGTH_LONG).show();
                    } else if (PhoneFragment.phone.getText().toString().charAt(27) == '_') {
                        Toast.makeText(getActivity(), "Eksik veya hatalı tuşladınız!", Toast.LENGTH_LONG).show();
                    } else {
                        view_pager_rec.setCurrentItem(view_pager_rec.getCurrentItem() + 1);
                    }
                } else if (view_pager_rec.getCurrentItem() == 4) {
                    if (BirthDateFragment.birth_date.getText().toString().equals("")) {
                        Toast.makeText(getActivity(), "Doğum tarihi boş geçilemez!", Toast.LENGTH_LONG).show();
                    } else {
                        view_pager_rec.setCurrentItem(view_pager_rec.getCurrentItem() + 1);
                    }
                }

                visibleControl();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.Shake).playOn(view.findViewById(R.id.previous));
                view_pager_rec.setCurrentItem(view_pager_rec.getCurrentItem() - 1);
                visibleControl();
            }
        });

        return view;


    }


    /*ScaleTouchListener.Config config = new ScaleTouchListener.Config(
            300,    // Duration
            0.85f,  // ScaleDown
            0.85f); // Alpha
    */

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpViewPager(view_pager_rec);
        tab_rec.setViewPager(view_pager_rec);
        view_pager_rec.setCurrentItem(0);

    }

    private void setUpViewPager(ViewPager view_pager_rec) {
        ViewAdapter adapter = new ViewAdapter(getChildFragmentManager());
        adapter.FragmentEkle(new NameFragment(), "Name");
        adapter.FragmentEkle(new MailFragment(), "Mail");
        adapter.FragmentEkle(new PasswordFragment(), "Password");
        adapter.FragmentEkle(new PhoneFragment(), "Phone");
        adapter.FragmentEkle(new BirthDateFragment(), "BirthDate");
        adapter.FragmentEkle(new CityFragment(), "City");
        view_pager_rec.setAdapter(adapter);
    }

    public void visibleControl() {
        tab_rec.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position == 0) {
                    previous.setClickable(false);
                    Drawable grayIcon = getActivity().getDrawable(R.drawable.left_button);
                    grayIcon.setTint(Color.parseColor("#B6B6B4"));
                    previous.setBackground(grayIcon);
                } else if (position == 5) {
                    next.setClickable(false);
                    Drawable grayIcon = getActivity().getDrawable(R.drawable.right_button);
                    grayIcon.setTint(Color.parseColor("#B6B6B4"));
                    next.setBackground(grayIcon);

                } else {
                    Drawable blackIconleft = getActivity().getDrawable(R.drawable.left_button);
                    blackIconleft.setTint(Color.parseColor("#000000"));
                    Drawable blackIconright = getActivity().getDrawable(R.drawable.right_button);
                    blackIconright.setTint(Color.parseColor("#000000"));
                    next.setBackground(blackIconright);
                    previous.setBackground(blackIconleft);
                    previous.setClickable(true);
                    next.setClickable(true);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


}

package com.example.appointmentproject.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> fragmentBaslikList = new ArrayList<>();

    public ViewAdapter(FragmentManager fm) {
        super(fm);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentBaslikList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentBaslikList.get(position);
    }

    public void FragmentEkle(Fragment fragment, String baslik) {

        fragmentList.add(fragment);
        fragmentBaslikList.add(baslik);
    }
}

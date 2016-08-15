package com.example.hackeru.tabsthenewway;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by hackeru on 14/08/2016.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<String> tabsTitles = new ArrayList<>();
    private ArrayList<Fragment> fragmentsList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager){
        super(manager);
    }

    public void add(Fragment fragment, String title){
        fragmentsList.add(fragment);
        tabsTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabsTitles.get(position);
    }
}

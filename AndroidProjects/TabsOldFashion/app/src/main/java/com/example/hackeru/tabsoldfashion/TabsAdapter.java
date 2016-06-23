package com.example.hackeru.tabsoldfashion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by hackeru on 22/06/2016.
 */
public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new MainFragment();
            case 1:
                return new AboutFragment();
            case 2:
                return new ProfileFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}

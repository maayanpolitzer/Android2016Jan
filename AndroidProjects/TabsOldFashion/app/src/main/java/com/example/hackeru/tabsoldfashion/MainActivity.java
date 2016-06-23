package com.example.hackeru.tabsoldfashion;


import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, ViewPager.OnPageChangeListener {

    ActionBar actionBar;
    ViewPager viewPager;
    TabsAdapter adapter;
    String[] tabNames = {"Main", "About", "Profile"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        actionBar = getSupportActionBar();
        adapter = new TabsAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (String tab : tabNames){
            actionBar.addTab(actionBar.newTab().setText(tab).setTabListener(this));
        }
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        actionBar.setSelectedNavigationItem(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

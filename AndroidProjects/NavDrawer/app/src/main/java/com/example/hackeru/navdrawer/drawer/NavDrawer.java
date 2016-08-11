package com.example.hackeru.navdrawer.drawer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hackeru.navdrawer.BaseActivity;
import com.example.hackeru.navdrawer.R;

import java.util.ArrayList;

/**
 * Created by hackeru on 10/08/2016.
 */

public class NavDrawer {

    private ArrayList<NavDrawerItem> items;     // views in the navDrawer
    private NavDrawerItem selectedItem;         // the current activity.

    protected BaseActivity activity;            // pointer to the current activity.
    protected DrawerLayout drawerLayout;        // pointer to the navDrawer layout + activity
    protected ViewGroup navDrawerView;          // pointer to the drawer!

    public NavDrawer(BaseActivity activity){
        this.activity = activity;
        items = new ArrayList<>();
        drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        navDrawerView = (ViewGroup) activity.findViewById(R.id.nav_drawer);
    }

    public void addItem(NavDrawerItem item){
        items.add(item);
        item.navDrawer = this;
    }

    public boolean isOpen(){
        return drawerLayout.isDrawerOpen(Gravity.LEFT);
    }

    public void setOpen(boolean b){
        if (b){ // b == true;
            drawerLayout.openDrawer(Gravity.LEFT);
        }else{
            drawerLayout.closeDrawer(Gravity.LEFT);
        }
    }

    public void setSelectedItem(NavDrawerItem item){
        if (selectedItem != null){
            selectedItem.setSelected(false);
        }
        selectedItem = item;
        selectedItem.setSelected(true);
    }

    public void create(){
        LayoutInflater inflater = activity.getLayoutInflater();
        for (NavDrawerItem item : items){
            item.inflate(inflater, navDrawerView);
        }
    }

    public static abstract class NavDrawerItem {
        protected NavDrawer navDrawer;
        public abstract void inflate(LayoutInflater inflater, ViewGroup container);
        public abstract void setSelected(boolean isSelected);
    }

    public static class BasicNavDrawerItem extends NavDrawerItem implements View.OnClickListener {

        private String text;
        private int iconDrawable;
        private int containerId;
        private int defaultColor;

        private ImageView icon;
        private TextView textView;
        private View view;

        public BasicNavDrawerItem(String text, int iconDrawable, int containerId){
            this.text = text;
            this.iconDrawable = iconDrawable;
            this.containerId = containerId;
        }

        @Override
        public void onClick(View v) {
            navDrawer.setSelectedItem(this);
        }

        @Override
        public void inflate(LayoutInflater inflater, ViewGroup navDrawerView) {
            ViewGroup container = (ViewGroup) navDrawerView.findViewById(containerId);
            view = inflater.inflate(R.layout.list_item_nav_drawer, container, false);
            container.addView(view);
            view.setOnClickListener(this);
            icon = (ImageView) view.findViewById(R.id.list_item_nav_drawer_icon);
            textView = (TextView) view.findViewById(R.id.list_item_nav_drawer_text);
            icon.setImageResource(iconDrawable);
            textView.setText(text);
            defaultColor = textView.getCurrentTextColor();
        }

        @Override
        public void setSelected(boolean isSelected) {
            if (isSelected){
                view.setBackgroundColor(Color.RED);
                textView.setTextColor(Color.parseColor("#ffffff"));
            }else{
                view.setBackground(null);
                textView.setTextColor(defaultColor);
            }
        }

        public void setText(String text){
            this.text = text;
            if (view != null){
                textView.setText(text);
            }
        }

        public void setIconDrawable(int iconDrawable){
            this.iconDrawable = iconDrawable;
            if (view != null){
                icon.setImageResource(iconDrawable);
            }
        }

    }

    public static class ActivityDrawerItem extends BasicNavDrawerItem {

        private Class targetActivity;

        public ActivityDrawerItem(Class targetActivity, String text, int iconDrawable, int containerId){
            super(text, iconDrawable, containerId);
            this.targetActivity = targetActivity;
        }

        @Override
        public void inflate(LayoutInflater inflater, ViewGroup navDrawerView) {
            super.inflate(inflater, navDrawerView);
            if (navDrawer.activity.getClass() == targetActivity){
                navDrawer.setSelectedItem(this);
            }
        }

        @Override
        public void onClick(View v) {
            navDrawer.setOpen(false);
            if (navDrawer.activity.getClass() == targetActivity){
                return;
            }
            super.onClick(v);
            Intent intent = new Intent(navDrawer.activity, targetActivity);
            navDrawer.activity.startActivity(intent);
            navDrawer.activity.finish();
        }
    }
}

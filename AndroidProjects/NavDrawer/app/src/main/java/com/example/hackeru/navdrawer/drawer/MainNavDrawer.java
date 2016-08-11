package com.example.hackeru.navdrawer.drawer;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hackeru.navdrawer.BaseActivity;
import com.example.hackeru.navdrawer.MainActivity;
import com.example.hackeru.navdrawer.ProfileActivity;
import com.example.hackeru.navdrawer.R;
import com.example.hackeru.navdrawer.SettingsActivity;

/**
 * Created by hackeru on 10/08/2016.
 */

public class MainNavDrawer extends NavDrawer {

    private TextView usernameTextView;
    private ImageView usernameImageView;

    public MainNavDrawer(final BaseActivity activity) {
        super(activity);

        addItem(new ActivityDrawerItem(MainActivity.class, "Home", android.R.drawable.ic_menu_close_clear_cancel, R.id.nav_drawer_top_linear_layout));
        addItem(new ActivityDrawerItem(SettingsActivity.class, "Settings", android.R.drawable.ic_dialog_info, R.id.nav_drawer_top_linear_layout));
        addItem(new BasicNavDrawerItem("Share", R.mipmap.ic_launcher, R.id.nav_drawer_bottom_linear_layout){
            @Override
            public void onClick(View v) {
                super.onClick(v);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                activity.startActivity(intent);
            }
        });
        addItem(new ActivityDrawerItem(ProfileActivity.class, "Profile", android.R.drawable.presence_online, R.id.nav_drawer_bottom_linear_layout));

    }
}

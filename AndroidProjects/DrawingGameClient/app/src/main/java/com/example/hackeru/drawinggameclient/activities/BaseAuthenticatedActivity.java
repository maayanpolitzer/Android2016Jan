package com.example.hackeru.drawinggameclient.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.hackeru.drawinggameclient.R;

/**
 * Created by hackeru on 17/08/2016.
 */
public abstract class BaseAuthenticatedActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(!checkIfUserExists()){
            changeActivity(LoginActivity.class, null, true);
            return;
        }
        onLoggedIn(savedInstanceState);

    }

    protected abstract void onLoggedIn(Bundle savedInstanceState);

    private boolean checkIfUserExists(){

        String token = settings.getString(TOKEN, null);
        if (token != null){
            /**
             * TODO:
             * send data to server.
             * return the boolean that came back!!!
             */
            return true;
        }

        return false;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_authenticated, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_logout:
                logout();
                break;
        }
        return true;
    }

    private void logout(){
        editor.clear();
        editor.commit();
        changeActivity(LoginActivity.class, null, true);
    }
}

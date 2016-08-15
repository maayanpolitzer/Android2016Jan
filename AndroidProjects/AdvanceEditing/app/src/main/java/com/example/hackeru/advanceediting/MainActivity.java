package com.example.hackeru.advanceediting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText editText;
    private ActionMode editNameActionMode;
    private String lastState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lastState = "";

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        editText = (EditText) findViewById(R.id.editText);
        editText.setEnabled(false);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch(itemId){
            case R.id.edit_action:
                displayEditMenu();
                break;
        }
        return true;
    }



    private void displayEditMenu(){
        editNameActionMode = toolbar.startActionMode(new EditNameAction());
        editText.setEnabled(true);
    }

    private class EditNameAction implements ActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            getMenuInflater().inflate(R.menu.menu_main_edit, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            int itemId = item.getItemId();
            switch (itemId){
                case R.id.done_action:
                    lastState = editText.getText().toString();
                    editText.setEnabled(false);
                    break;
            }
            editNameActionMode.finish();
            editNameActionMode = null;
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            editText.setText(lastState);
            editText.setEnabled(false);
            editNameActionMode.finish();
            editNameActionMode = null;
        }
    }

}

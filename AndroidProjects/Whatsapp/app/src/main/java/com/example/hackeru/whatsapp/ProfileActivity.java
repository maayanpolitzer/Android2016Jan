package com.example.hackeru.whatsapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int CHOOSE_AVATAR_REQUEST_CODE = 1;
    private static final String PREFS_NAME = "myPrefsFile";
    private static final String IMAGE_PATH = "imagePath";
    private static final String USERNAME = "username";

    private EditText usernameEditText;
    private ImageView avatarImageView;
    private ProgressBar progressBar;

    private SharedPreferences settings;
    private SharedPreferences.Editor editor;

    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        usernameEditText = (EditText) findViewById(R.id.activity_profile_username_edit_text);
        avatarImageView = (ImageView) findViewById(R.id.activity_profile_avatar_image_view);
        progressBar = (ProgressBar) findViewById(R.id.activity_profile_progress_bar);

        findViewById(R.id.activity_profile_save_button).setOnClickListener(this);
        findViewById(R.id.activity_profile_change_avatar_frame_layout).setOnClickListener(this);

        settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        editor = settings.edit();

        //display image if saved...
        String path = settings.getString(IMAGE_PATH, null);
        if (path != null){
            imageUri = Uri.parse(path);
            avatarImageView.setImageURI(imageUri);
        }

        String username = settings.getString(USERNAME, null);
        if (username != null){
            usernameEditText.setText(username);
        }


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch(id){
            case R.id.activity_profile_save_button:
                saveAndClose();
                break;
            case R.id.activity_profile_change_avatar_frame_layout:
                pickPhotoFromGallery();
                break;
        }
    }

    private void pickPhotoFromGallery(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, CHOOSE_AVATAR_REQUEST_CODE);
    }

    private void saveAndClose(){
        String username = usernameEditText.getText().toString().trim();
        if (validate(username)){
            editor.putString(IMAGE_PATH, imageUri.getPath());
            editor.putString(USERNAME, username);
            editor.commit();
            setResult(RESULT_OK);
            finish();
        }
    }

    private boolean validate(String str){
        if (str.isEmpty()){
            usernameEditText.setError("Username cannot stay empty...");
            return false;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CHOOSE_AVATAR_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                imageUri = data.getData();
                Log.d("Maayan", "Image uri: " + imageUri);
                avatarImageView.setImageURI(imageUri);
            }
        }
    }
}

package com.example.hackeru.savefiles;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    SharedPreferences settings;     // getData...
    SharedPreferences.Editor editor;    // save data...

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        // shared prefs...
        settings = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        editor = settings.edit();

        // saving data:
        editor.putString("USERNAME", "Maayan");
        editor.putString("PASSWORD", "123");
        editor.commit();

        String username = settings.getString("USERNAME", null);

        if(username == null){
            Toast.makeText( this, "NO USERNAME", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText( this, "Hello :" + username, Toast.LENGTH_SHORT).show();
        }
        */

        /*
        // save to new file. (internal storage)
        String fileName = "internalFile.txt";
        String content = "hi all, how r u?";
        try {
            FileOutputStream out = openFileOutput(fileName, MODE_PRIVATE);
            out.write(content.getBytes());
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /*
        // append data to file. (without erase.
        File f = new File(getFilesDir(), "internalFile.txt");

        try{
            FileWriter writer = new FileWriter(f, true);
            String newContent = "\nFine tn222x.";
            writer.append(newContent);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        */

        /*
        // get data from internal storage file...
        try{
            FileInputStream in = openFileInput("internalFile.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null){
                sb.append(line + "\n");
            }
            in.close();
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

        /*
        //      write to external storage...
        if (isExternalStorageAvailable()){
            String fileName = "externalStorageFile.txt";
            File f = new File(Environment.getExternalStorageDirectory(), fileName);
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */

        // check if file exists and get data from it.
        String fileName = "externalStorageFile.txt";
        File f = new File(Environment.getExternalStorageDirectory(), fileName);
        if(f.exists()){
            Toast.makeText(this, "file exists!!!", Toast.LENGTH_LONG).show();
        }


    }

    private boolean isExternalStorageAvailable(){
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)){
            return true;
        }
        return false;
    }

}

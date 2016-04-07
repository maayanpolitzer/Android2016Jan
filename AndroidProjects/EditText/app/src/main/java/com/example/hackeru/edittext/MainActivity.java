package com.example.hackeru.edittext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        for (int i = 0 ; i < 100; i++){
            TextView t = new TextView(this);
            t.setText("text vierw: " + i);
            mainLayout.addView(t);
        }

    }

    public void getName(View view) {
        /*
        EditText name = (EditText) findViewById(R.id.name);
        String myName = name.getText().toString();
        //Toast.makeText(this, "Hello " + myName, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, NameActivity.class);
        intent.putExtra("name", myName);
        intent.putExtra("age", 44);
        startActivity(intent);
*/
    }
}

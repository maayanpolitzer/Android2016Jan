package com.example.hackeru.startactivityforresults;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, 3454);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 3454){   // from where i came back...
            if (resultCode == 190){   // how i came back...
                Toast.makeText(this, data.getStringExtra("name"), Toast.LENGTH_LONG).show();
            }else if (resultCode == RESULT_CANCELED){   // by back btn.
                Toast.makeText(this, "canceled", Toast.LENGTH_LONG).show();

            }

        }
    }
}

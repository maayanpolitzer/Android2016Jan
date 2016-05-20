package com.maayanpolitzer.dialogfragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnDialogCloseListener {

    public static final String TITLE = "title";
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, "My title");
        MyDialog dialog = new MyDialog();   // constructor MUST stay empty!
        dialog.setArguments(bundle);    // send data to the dialog by bundle.
        dialog.show(getFragmentManager(), "TAG");
    }

    @Override
    public void onClose(String username, String password) {
        if (username.equals("maayan") && password.equals("123")) {
            Toast.makeText(this, "YEY!!!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "OH NO!!!", Toast.LENGTH_LONG).show();
        }
    }
}

package com.example.hackeru.clientsocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText messageEditText;
    private Button sendBtn;
    private TextView statusTextView;

    public static final int MAAYAN = 1;
    public static final int IGOR = 2;
    public static final int REFAEL = 3;
    public static final int RAN = 4;
    public static final int YULIA = 5;

    public static final int ME = MAAYAN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageEditText = (EditText) findViewById(R.id.editText);
        sendBtn = (Button) findViewById(R.id.sendBtn);
        statusTextView = (TextView) findViewById(R.id.statusTextView);

        sendBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String message = messageEditText.getText().toString().trim();
        if (!message.isEmpty()){
            new SendMessageThread(message, statusTextView).start();
        }
    }
}

package com.example.hackeru.clientsocket;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, GetMessageThread.ReceivedMessageListener {

    private EditText messageEditText;
    private Button sendBtn;
    private TextView statusTextView;
    private Button getMessageBtn;
    private EditText toEditText;

    public static final int MAAYAN = 1;
    public static final int IGOR = 2;
    public static final int REFAEL = 3;
    public static final int RAN = 4;
    public static final int YULIA = 5;
    private HashMap<Integer, String> names;

    private void initMap() {
        names = new HashMap<>();
        names.put(1,"Maayan");
        names.put(2,"Igor");
        names.put(3,"Refael");
        names.put(4,"Ran");
        names.put(5,"Yulia");
    }



    public static final int ME = MAAYAN;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageEditText = (EditText) findViewById(R.id.editText);
        sendBtn = (Button) findViewById(R.id.sendBtn);
        statusTextView = (TextView) findViewById(R.id.statusTextView);
        getMessageBtn = (Button) findViewById(R.id.getMessageBtn);
        toEditText = (EditText) findViewById(R.id.toEditText);

        sendBtn.setOnClickListener(this);
        getMessageBtn.setOnClickListener(this);

        handler = new Handler();
        initMap();

    }

    @Override
    public void onClick(View v) {
        if (v == sendBtn) {
            String message = messageEditText.getText().toString().trim();
            if (!message.isEmpty()) {
                new SendMessageThread(Integer.parseInt(toEditText.getText().toString()),message, statusTextView).start();
            }
        }else if(getMessageBtn == v){
            new GetMessageThread(this).start();
        }
    }

    @Override
    public void onMessageArrived(final int from, final String message) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                statusTextView.setText("Message from: " + names.get(from) + ": " + message);
            }
        });
    }
}

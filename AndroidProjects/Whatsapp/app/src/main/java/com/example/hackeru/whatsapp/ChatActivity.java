package com.example.hackeru.whatsapp;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mainLayout;
    private ImageView sendBtnImageView;
    private EditText messageInputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        mainLayout = (LinearLayout) findViewById(R.id.activity_chat_main_layout);
        sendBtnImageView = (ImageView) findViewById(R.id.input_area_send_image_view);
        messageInputEditText = (EditText) findViewById(R.id.input_area_message_edit_text);

        sendBtnImageView.setOnClickListener(this);

    }

    public void sendMessage(String message) {

        LinearLayout sendMessageLayout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        sendMessageLayout.setOrientation(LinearLayout.HORIZONTAL);
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 6);
        tvParams.setMargins(0, 10, 0, 0);
        tv.setText(message);
        tv.setTextColor(Color.parseColor("#000000"));
        tv.setPadding(16, 16, 16, 16);
        tv.setBackgroundResource(R.drawable.rounded_corner_in);
        sendMessageLayout.addView(tv, params);
        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams ivParams = new LinearLayout.LayoutParams(30, 30);
        ivParams.setMargins(-15, 9,0,0);
        imageView.setImageResource(R.drawable.arrow_in);
        sendMessageLayout.addView(imageView, ivParams);
        mainLayout.addView(sendMessageLayout, params);


    }

    public void receiveMessage(View view) {
        LinearLayout sendMessageLayout = new LinearLayout(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        sendMessageLayout.setOrientation(LinearLayout.HORIZONTAL);
        ImageView imageView = new ImageView(this);
        LinearLayout.LayoutParams ivParams = new LinearLayout.LayoutParams(30, 30);
        ivParams.setMargins(0,9,-15,0);
        imageView.setImageResource(R.drawable.arrow_out);
        sendMessageLayout.addView(imageView, ivParams);
        TextView tv = new TextView(this);
        LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 6);
        tvParams.setMargins(0, 10, 0, 0);
        tv.setText("Working!!!");
        tv.setTextColor(Color.parseColor("#000000"));
        tv.setPadding(16, 16, 16, 16);
        tv.setBackgroundResource(R.drawable.rounded_corner_out);
        sendMessageLayout.addView(tv, params);

        mainLayout.addView(sendMessageLayout, params);
    }

    @Override
    public void onClick(View v) {
        String message = messageInputEditText.getText().toString().trim(); // "    hi you   "// "hi you"
        if (!message.isEmpty()){
            sendMessage(message);

            messageInputEditText.setText("");
        }else{
            messageInputEditText.setError("please dont send empty message ");
        }
    }
}

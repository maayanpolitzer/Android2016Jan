package com.example.hackeru.tipcaculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TIP = "tip";
    private Button calculateBtn;
    private EditText priceEt, tipEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculateBtn = (Button) findViewById(R.id.activity_main_calculate_button);
        priceEt = (EditText) findViewById(R.id.activity_main_price_edit_text);
        tipEt = (EditText) findViewById(R.id.activity_main_tip_edit_text);
        calculateBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        //Toast.makeText(this, "you clicked the button", Toast.LENGTH_LONG).show();
        String priceAsString = priceEt.getText().toString();
        String tipAsString = tipEt.getText().toString();
        if (!priceAsString.isEmpty() && !tipAsString.isEmpty()){
            double price = Double.parseDouble(priceAsString);
            double tip = Double.parseDouble(tipAsString);
            double fixedTip = calculate(price, tip);

            //Toast.makeText(this, "You should tip : " + fixedTip, Toast.LENGTH_LONG).show();

            Intent intent = new Intent(this, TipActivity.class);
            intent.putExtra(TIP, fixedTip);
            startActivity(intent);
        }else{
            if (priceAsString.isEmpty()){
                priceEt.setError("Can't be empty");
            }
            if (tipAsString.isEmpty()){
                tipEt.setError("Can't be empty");
            }
        }
    }

    private double calculate(double price, double tip){
        return price * (tip / 100);
    }
}

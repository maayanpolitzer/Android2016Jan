package com.example.hackeru.ratingsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    CheckBox checkBox;
    TextView textView;
    RadioGroup radioGroup;
    Button submitBtn;
    LinearLayout starLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBox = (CheckBox) findViewById(R.id.activity_main_check_box);
        checkBox.setOnCheckedChangeListener(this);
        textView = (TextView) findViewById(R.id.activity_main_text_view);
        radioGroup = (RadioGroup) findViewById(R.id.activity_main_radio_group);
        radioGroup.setOnCheckedChangeListener(this);
        submitBtn = (Button) findViewById(R.id.activity_main_submit_button);
        starLayout = (LinearLayout) findViewById(R.id.activity_main_star_linear_layout);
        for (int i = 1; i <= 5; i++){
            CheckBox star = (CheckBox) starLayout.findViewWithTag(String.valueOf(i));
            star.setOnClickListener(this);
        }

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        /*
        if (isChecked){
            textView.setVisibility(View.VISIBLE);
        }else{
            textView.setVisibility(View.INVISIBLE);
        }
        */
        textView.setVisibility(isChecked ? View.VISIBLE : View.INVISIBLE);
    }

    public void checkRadio(View view) {
        /*
        if (radioGroup.getCheckedRadioButtonId() != -1){
            Toast.makeText(this, "Thank you", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Please choose your gender", Toast.LENGTH_LONG).show();
        }
        */
        /*
        for (int i = 1; i <= 3; i++){
            CheckBox star = (CheckBox) starLayout.findViewWithTag(String.valueOf(i));
            star.setChecked(true);
        }
        */

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //Toast.makeText(this, checkedId + " is checked", Toast.LENGTH_LONG).show();
        if (!submitBtn.isEnabled()){
            submitBtn.setEnabled(true);
        }
        String gender = "";
        switch(checkedId){
            case R.id.male_radio_button:
                gender = "male";
                break;
            case R.id.female_radio_button:
                gender = "female";
                break;
            case R.id.between_radio_button:
                gender = "between";
                break;
        }
        //Toast.makeText(this, "You choosed: " + gender, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        int tag = Integer.parseInt(String.valueOf(v.getTag()));
        for (int i = 1; i <= 5 ; i++){
            CheckBox star = (CheckBox) starLayout.findViewWithTag(String.valueOf(i));
            if (i <= tag){
                star.setChecked(true);
            }else{
                star.setChecked(false);
            }
        }
    }
}

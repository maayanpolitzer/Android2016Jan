package com.example.hackeru.datepicker;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    EditText dateET, timeET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dateET = (EditText) findViewById(R.id.date_edit_text);
        timeET = (EditText) findViewById(R.id.time_edit_text);

        dateET.setOnClickListener(this);
        timeET.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Calendar c = Calendar.getInstance();
        if (v == dateET) {
            DatePickerDialog fragment = new DatePickerDialog(
                    this,
                    this,
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            );
            fragment.show();
        } else if (v == timeET) {
            TimePickerDialog dialog = new TimePickerDialog(
                    this,
                    this,
                    c.get(Calendar.HOUR_OF_DAY),
                    c.get(Calendar.MINUTE),
                    true
            );
            dialog.show();
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        dateET.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        timeET.setText((hourOfDay < 10 ? "0" + hourOfDay : hourOfDay) + ":" + (minute < 10 ? "0" + minute : minute));
    }
}

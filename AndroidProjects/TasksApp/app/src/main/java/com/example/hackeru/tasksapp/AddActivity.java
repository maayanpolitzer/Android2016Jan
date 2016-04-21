package com.example.hackeru.tasksapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {

    EditText taskEditText;
    Button saveTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        taskEditText = (EditText) findViewById(R.id.activity_add_task_edit_text);
        saveTaskButton = (Button) findViewById(R.id.activity_add_save_task_button);

        saveTaskButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String task = taskEditText.getText().toString().trim();
        if (!task.isEmpty()){
            Intent intent = new Intent();
            intent.putExtra("TASK", task);
            setResult(RESULT_OK, intent);
            finish();
        }else{
            taskEditText.setError("Not funny...");
        }
    }
}

package com.example.hackeru.tasksapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TaskActivity extends AppCompatActivity implements View.OnClickListener {


    Button deleteTaskButton;
    TextView taskTextView;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        String task = getIntent().getStringExtra("TASK");
        position = getIntent().getIntExtra("POSITION", -1);

        deleteTaskButton = (Button) findViewById(R.id.activity_task_delete_button);
        taskTextView = (TextView) findViewById(R.id.activity_task_text_view);

        taskTextView.setText(task);

        deleteTaskButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("POSITION", position);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_task_activity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch(itemId){
            case R.id.menu_delete_task_action:
                onClick(null);
                return true;
        }
        return false;
    }
}

package com.example.hackeru.tasksapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private static final int TASK_ACTIVITY_REQUEST_CODE = 1;
    private static final int ADD_ACTIVITY_REQUEST_CODE = 2;
    Button addTaskButton;
    ListView listView;
    ArrayList<String> tasks;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tasks = new ArrayList<>();
        tasks.add("fgdfgd");

        addTaskButton = (Button) findViewById(R.id.activity_main_add_task_button);
        listView = (ListView) findViewById(R.id.activity_main_list_view);

        addTaskButton.setOnClickListener(this);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, tasks);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, AddActivity.class);
        startActivityForResult(intent, ADD_ACTIVITY_REQUEST_CODE);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, TaskActivity.class);
        intent.putExtra("TASK",tasks.get(position));
        intent.putExtra("POSITION", position);
        startActivityForResult(intent, TASK_ACTIVITY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == TASK_ACTIVITY_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                // delete the task!!!!!!!!
                int position = data.getIntExtra("POSITION", -1);
                if (position != -1){
                    tasks.remove(position);
                    adapter.notifyDataSetChanged();
                }
            }
        }
        if (requestCode == ADD_ACTIVITY_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                String task = data.getStringExtra("TASK");
                tasks.add(task);
                adapter.notifyDataSetChanged();
            }
        }
    }
}

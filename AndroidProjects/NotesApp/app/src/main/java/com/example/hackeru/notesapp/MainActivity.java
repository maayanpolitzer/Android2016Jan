package com.example.hackeru.notesapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    private ListView listView;
    private TextView emptyListTextView;
    private Button addNoteBtn;
    private ArrayList<String> notesList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.activity_main_list_view);
        emptyListTextView = (TextView) findViewById(R.id.activity_main_empty_list);
        addNoteBtn = (Button) findViewById(R.id.activity_main_add_button);

        notesList = new ArrayList<>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, notesList);

        listView.setAdapter(adapter);
        listView.setEmptyView(emptyListTextView);
        listView.setOnItemClickListener(this);
        addNoteBtn.setOnClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // go to note activity to view/edit/delete note...
        Intent intent = new Intent(this, NoteActivity.class);
        intent.putExtra(ACTION, EDIT);
        intent.putExtra(NOTE, notesList.get(position));
        intent.putExtra(POSITION, position);
        startActivityForResult(intent, 2);
    }

    @Override
    public void onClick(View v) {
        // go to note activity to add new note...
        Intent intent = new Intent(this, NoteActivity.class);
        intent.putExtra(ACTION, ADD);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1){
            if (resultCode == RESULT_OK){
                String newNote = data.getStringExtra(TEXT);
                notesList.add(newNote);
                adapter.notifyDataSetChanged();
            }
        }
        if (requestCode == 2){
            if (resultCode == RESULT_OK){
                String newNote = data.getStringExtra(TEXT);
                int position = data.getIntExtra(POSITION, -1);
                if (position != -1){
                    notesList.set(position, newNote);
                    adapter.notifyDataSetChanged();
                }
            }else if(resultCode == RESULT_DELETE){
                int position = data.getIntExtra(POSITION, -1);
                if (position != -1){
                    notesList.remove(position);
                    adapter.notifyDataSetChanged();
                }
            }
        }
    }
}

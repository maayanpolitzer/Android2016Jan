package com.example.hackeru.notesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hackeru on 08/06/2016.
 */
public class NoteActivity extends BaseActivity implements View.OnClickListener, OnCloseDialogListener {


    private TextView titleTextView;
    private EditText noteBodyEditText;
    private Button saveNoteBtn;
    private Button deleteNoteBtn;

    private int position;
    private String action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        titleTextView = (TextView) findViewById(R.id.note_activity_title);
        noteBodyEditText = (EditText) findViewById(R.id.activity_note_edit_text);
        saveNoteBtn = (Button) findViewById(R.id.activity_note_save_button);
        deleteNoteBtn = (Button) findViewById(R.id.activity_note_delete_button);

        saveNoteBtn.setOnClickListener(this);
        deleteNoteBtn.setOnClickListener(this);


        action = getIntent().getStringExtra(ACTION);
        if (action.equals(ADD)){
            // I'm here to add new note!!!
            titleTextView.setText("Add new note");
            deleteNoteBtn.setVisibility(View.GONE);
        }else{
            // just watching / editing / deleting...
            titleTextView.setText("Edit note");
            noteBodyEditText.setText(getIntent().getStringExtra(NOTE));
            position = getIntent().getIntExtra(POSITION, -1);
            deleteNoteBtn.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v == saveNoteBtn){
            String note = noteBodyEditText.getText().toString().trim();
            if (!note.isEmpty()) {
                if (action == ADD) {   // add new note
                    Intent intent = new Intent();
                    intent.putExtra(TEXT, note);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {  //      i want to update data...
                    Intent intent = new Intent();
                    intent.putExtra(TEXT, note);
                    intent.putExtra(POSITION, position);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        }else if(v == deleteNoteBtn){
            DeleteNoteDialog dialog = new DeleteNoteDialog();
            dialog.show(getFragmentManager(), "");
        }
    }

    @Override
    public void onDelete() {
        Intent intent = new Intent();
        intent.putExtra(POSITION, position);
        setResult(RESULT_DELETE, intent);
        finish();
    }
}

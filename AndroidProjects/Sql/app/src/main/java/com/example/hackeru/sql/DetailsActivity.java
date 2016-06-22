package com.example.hackeru.sql;

import android.content.ContentValues;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    TextView name;
    EditText grade;
    Button updateBtn;
    String filter;  // "_id=" + id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name = (TextView) findViewById(R.id.nameTV);
        grade = (EditText) findViewById(R.id.gradeET);
        updateBtn = (Button) findViewById(R.id.updateBtn);
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newGrade = Integer.parseInt(grade.getText().toString());
                updateDB(newGrade);
            }
        });

        int id = getIntent().getIntExtra("id", -1);
        filter = DBOpenHelper.GRADES_ID + "=" + id;

        if (id != -1){
            getDataFromDB();
        }

    }

    private void updateDB(int grade){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.GRADES_GRADE, 999);
        getContentResolver().update(GradesProvider.CONTENT_URI, values, filter, null);
        /*
        // filter = "_id=5";
        getContentResolver().update(GradesProvider.CONTENT_URI, values,
                DBOpenHelper.GRADES_NAME + "=?",
                new String[]{"Kevin2"});
                */
        setResult(RESULT_OK);
        finish();
    }

    private void getDataFromDB(){
        Cursor cursor = getContentResolver().query(GradesProvider.CONTENT_URI,
                DBOpenHelper.GRADES_ALL_COLUMNS, filter, null, null);
        if (cursor != null){
            cursor.moveToFirst();
            name.setText(cursor.getString(cursor.getColumnIndex(DBOpenHelper.GRADES_NAME)));
            grade.setText(cursor.getInt(cursor.getColumnIndex(DBOpenHelper.GRADES_GRADE)) + "");
        }else{
            name.setText("Cursor is NULL!!!");
        }

    }
}

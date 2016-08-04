package com.example.hackeru.tappinggame;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by hackeru on 03/08/2016.
 */
public class ScoreAdapter extends CursorAdapter {

    public ScoreAdapter(Context context, Cursor cursor){
        super(context,cursor,0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView name = (TextView) view.findViewById(R.id.list_item_name);
        TextView score = (TextView) view.findViewById(R.id.list_item_score);

        String playerName = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COLUMN_NAME));
        int playerScore = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.COLUMN_SCORE));

        name.setText(playerName);
        score.setText(playerScore + "");

    }
}

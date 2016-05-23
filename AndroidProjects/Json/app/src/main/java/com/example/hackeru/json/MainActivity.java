package com.example.hackeru.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {


    String json = "{\"from\":\"Maayan\", \"to\":\"Liri\", \"body\":\"hi\"}";
    String jsonArr = "[{\"from\":\"Maayan\", \"to\":\"Liri\", \"body\":\"hi\"},{\"from\":\"David\", \"to\":\"Kevin\", \"body\":\"How are you\"}]";
    String complex = "{\"results\":[{\"name\":\"Maayan\"},{\"name\":\"Moshe\"},{\"name\":\"Ran\"}]}";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        try {
            JSONObject obj = new JSONObject(json);
            Toast.makeText(this, obj.getString("from"), Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */
        /*
        try {
            JSONArray array = new JSONArray(jsonArr);
            for (int i = 0; i < array.length(); i++){
                //JSONObject obj = (JSONObject) array.get(i);   // the same as next line...
                JSONObject obj = array.getJSONObject(i);
                Toast.makeText(this, obj.getString("from"), Toast.LENGTH_LONG).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */

        try {
            JSONObject obj = new JSONObject(complex);
            //JSONArray arr = (JSONArray)obj.get("results");    / the same as next line;
            JSONArray arr = obj.getJSONArray("results");
            for (int i = 0; i < arr.length(); i++){
                //JSONObject obj2 = (JSONObject) array.get(i);   // the same as next line...
                JSONObject obj2 = arr.getJSONObject(i);
                Toast.makeText(this, obj2.getString("name"), Toast.LENGTH_LONG).show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}

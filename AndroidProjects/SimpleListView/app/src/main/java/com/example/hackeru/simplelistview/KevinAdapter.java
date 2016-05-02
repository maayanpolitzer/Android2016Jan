package com.example.hackeru.simplelistview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hackeru on 01/05/2016.
 */
public class KevinAdapter extends ArrayAdapter<Country> {

    private Context context;
    private Country[] countries;

    public KevinAdapter(Context context, int resource, Country[] countries) {
        super(context, resource, countries);
        this.context = context;
        this.countries = countries;
    }

    private static class ViewHolder{
        TextView textView;
        ImageView imageView;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null){
            Log.d("Maayan", "NULL");
            // create;
            viewHolder = new ViewHolder();

            // get java from xml.
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null, false);

            // get pointers / references.
            viewHolder.textView = (TextView) convertView.findViewById(R.id.list_item_text);
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.list_item_image);
            viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, FlagActivity.class);
                    intent.putExtra("FLAG", countries[position].getImage());
                    context.startActivity(intent);
                }
            });
            convertView.setTag(viewHolder);
        }else{
            Log.d("Maayan", "RECYCLE");
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // insert data.
        viewHolder.textView.setText(countries[position].getName());
        viewHolder.imageView.setImageResource(countries[position].getImage());
        //return view from parameter.
        return convertView;
    }
}

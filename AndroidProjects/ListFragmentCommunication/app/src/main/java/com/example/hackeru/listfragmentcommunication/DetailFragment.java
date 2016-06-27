package com.example.hackeru.listfragmentcommunication;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hackeru on 26/06/2016.
 */
public class DetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        TextView nameTextView = (TextView) rootView.findViewById(R.id.fragment_detail_name_text_view);

        Bundle args = getArguments();
        String name = args.getString(MainActivity.NAME);
        nameTextView.setText(name);

        return rootView;
    }
}

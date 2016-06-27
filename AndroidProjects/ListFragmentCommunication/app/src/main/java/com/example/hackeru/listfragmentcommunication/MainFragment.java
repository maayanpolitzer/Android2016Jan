package com.example.hackeru.listfragmentcommunication;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by hackeru on 26/06/2016.
 */
public class MainFragment extends ListFragment {

    private String[] names = {
            "Maayan", "Roy", "Ronen", "Guy", "Liri", "Oz"
    };
    private Callbacks listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, names);

        setListAdapter(adapter);

        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        listener.onItemClick(names[position]);
    }

    public interface Callbacks {
        void onItemClick(String name);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (Callbacks) context;
    }
}

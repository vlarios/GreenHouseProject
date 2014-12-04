package com.example.vlarios.greenhouseproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by vlarios on 11/24/2014.
 */


public class CommandsTab extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.commands_tab, container, false);
        ListView listView = (ListView) view.findViewById(R.id.list_elements);
        final SensorsListItemAdapter listItemAdapter = new SensorsListItemAdapter(getActivity().getBaseContext(), MainWindow.commandsArray);
        listView.setAdapter(listItemAdapter);
        return view;
    }
}

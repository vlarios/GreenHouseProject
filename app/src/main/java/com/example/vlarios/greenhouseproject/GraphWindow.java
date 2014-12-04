package com.example.vlarios.greenhouseproject;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.RelativeLayout;
/**
 * Created by vlarios on 12/1/2014.
 */
public class GraphWindow extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.graph_window, container, false);
        TextView textview = (TextView) view.findViewById(R.id.graph_window_textview);
        textview.setText(MainWindow.sensorStr + " - Gráfica:");
        RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R.id.graph_window);
        relativeLayout.addView(new DrawArea(getActivity()));
        return view;

    }
}

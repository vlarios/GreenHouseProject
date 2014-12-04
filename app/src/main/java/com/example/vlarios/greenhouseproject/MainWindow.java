package com.example.vlarios.greenhouseproject;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.Fragment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class MainWindow extends Activity {

    public static ArrayList<ListItem> sensorsArray = null;
    public static ArrayList<ListItem> commandsArray = null;
    public static String sensorStr = "";
    ActionBar.Tab tab1, tab2;
    Fragment sensorsTab = new SensorsTab();
    Fragment commandsTab = new CommandsTab();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window);

        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        tab1 = actionBar.newTab().setText("Sensores");
        tab2 = actionBar.newTab().setText("Comandos");


        tab1.setTabListener(new TabListener(sensorsTab));
        tab2.setTabListener(new TabListener(commandsTab));


        actionBar.addTab(tab1);
        actionBar.addTab(tab2);

        sensorsArray = new ArrayList<ListItem>();

        updateSensorsArray("Temperatura 1");
        updateSensorsArray("Temperatura 2");
        updateSensorsArray("Temperatura 3");
        updateSensorsArray("Temperatura 4");
        updateSensorsArray("Temperatura 5");
        updateSensorsArray("Humedad 1");
        updateSensorsArray("Humedad 2");
        updateSensorsArray("Humedad 3");
        updateSensorsArray("Humedad 4");
        updateSensorsArray("Humedad 5");
        updateSensorsArray("PH 1");
        updateSensorsArray("PH 2");
        updateSensorsArray("PH 3");
        updateSensorsArray("PH 4");
        updateSensorsArray("PH 5");

        commandsArray = new ArrayList<ListItem>();

        updateCommandsArray("Compuerta 1");
        updateCommandsArray("Compuerta 2");
        updateCommandsArray("Compuerta 3");
        updateCommandsArray("Compuerta 4");
        updateCommandsArray("Compuerta 5");
        updateCommandsArray("Ventilador 1");
        updateCommandsArray("Ventilador 2");
        updateCommandsArray("Ventilador 3");
        updateCommandsArray("Ventilador 4");
        updateCommandsArray("Ventilador 5");
        updateCommandsArray("Sistema de riego 1");
        updateCommandsArray("Sistema de riego 2");
        updateCommandsArray("Sistema de riego 3");
        updateCommandsArray("Sistema de riego 4");
        updateCommandsArray("Sistema de riego 5");


    }

    private void updateSensorsArray(String str) {
        ListItem listItem = new ListItem();
        listItem.setHeader(str);
        sensorsArray.add(listItem);
    }

    private void updateCommandsArray(String str) {
        ListItem listItem = new ListItem();
        listItem.setHeader(str);
        commandsArray.add(listItem);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_window, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void goTosensorTimeSel2(View view) {
        SensorTimeSel2 sensorTimeSel2 = new SensorTimeSel2();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sensor_time_sel, sensorTimeSel2);
        fragmentTransaction.commit();
    }

    public void goToGraphWindow(View view) {
        GraphWindow graphWindow = new GraphWindow();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sensor_time_sel_2, graphWindow);
        fragmentTransaction.commit();
    }

    public void goToSensorsTab(View view) {
        SensorsTab sensorsTab = new SensorsTab();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.graph_window, sensorsTab);
        fragmentTransaction.commit();
    }
}

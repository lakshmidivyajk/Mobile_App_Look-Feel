package com.example.divya.gridproject2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by DIVYA on 10/2/2017.
 */

public class listViewAdapter extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i = getIntent();//get the intent
        int pos = i.getIntExtra(MainActivity.POS, 0);//determine the position of the grid item using the extra pos
       //Based on the position we set the listAdapter
        //For setting the listAdapter we are passing the 3 dealers' details in the ArrayAdapter
        //The 3 dealers' details for each brand are stroed as a string-array with dealer as the items
        //R.layout.dealer_layout is the id of the layout dealer_layout used for displaying the list view
        switch (pos) {
            case 0:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_layout,
                        getResources().getStringArray(R.array.honda)));
                break;
            case 1:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_layout,
                        getResources().getStringArray(R.array.lincoln)));
                break;
            case 2:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_layout,
                        getResources().getStringArray(R.array.ford)));
                break;
            case 3:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_layout,
                        getResources().getStringArray(R.array.nissan)));
                break;
            case 4:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_layout,
                        getResources().getStringArray(R.array.chrysler)));
                break;
            case 5:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_layout,
                        getResources().getStringArray(R.array.dodge)));
                break;
            case 6:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_layout,
                        getResources().getStringArray(R.array.tesla)));
                break;
            case 7:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_layout,
                        getResources().getStringArray(R.array.bmw)));
                break;
            case 8:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_layout,
                        getResources().getStringArray(R.array.benz)));
                break;
            case 9:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_layout,
                        getResources().getStringArray(R.array.gmc)));
                break;
            case 10:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_layout,
                        getResources().getStringArray(R.array.jeep)));
                break;
            case 11:
                setListAdapter(new ArrayAdapter<String>(this, R.layout.dealer_layout,
                        getResources().getStringArray(R.array.toyota)));
                break;


        }

        ListView lv = getListView();//getting the listView
        lv.setEnabled(false);//to disable click on the listView
        lv.setOnItemClickListener(null);//setOnItemClickListener is null since click is disabled

    }
}

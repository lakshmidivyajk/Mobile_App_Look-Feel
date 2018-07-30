package com.example.divya.demo_midterm;

import android.app.ListActivity;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by DIVYA on 10/11/2017.
 */

public class listDemo extends ListActivity {
    ArrayList<String> cars=new ArrayList<String>(Arrays.asList("a","b","c"));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView lv=getListView();
        ArrayAdapter<String>list=new ArrayAdapter<String>(this,R.layout.list,R.id.tv,cars);
        lv.setAdapter(list);



    }
    public void OnListItem(AdapterView<?> parent,View view,int position,long id){

    }




}

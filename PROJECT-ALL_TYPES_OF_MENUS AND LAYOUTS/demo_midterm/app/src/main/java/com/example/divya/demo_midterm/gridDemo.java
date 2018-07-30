package com.example.divya.demo_midterm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by DIVYA on 10/11/2017.
 */

public class gridDemo extends AppCompatActivity {
    ArrayList<Integer> cars=new ArrayList<Integer>(Arrays.asList(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4));
    String[] carNames={"a","b","c","d"};
    TextView tv;
   // ArrayList<String> carNames=new ArrayList<String>(Arrays.asList("a","b","c","d"));
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid);
        GridView gv=(GridView)findViewById(R.id.grid);

        gv.setAdapter(new ImageAdapter(this,cars,carNames));


        gv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?>parent, View view,int position,long id){

               // Toast.makeText(gridDemo.this,carNames[position],Toast.LENGTH_LONG).show();
                Intent i=new Intent(gridDemo.this,ImageActivity.class);
                i.putExtra("EXTRA_RES_ID",(int)id);
                startActivity(i);
            }
        });

        registerForContextMenu(gv);






    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,view,menuInfo);
        MenuInflater mi=getMenuInflater();
        mi.inflate(R.menu.menu_main,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem contextMenuItem){
        switch(contextMenuItem.getItemId()){
            case R.id.help:Toast.makeText(gridDemo.this,"Helping CONTEXT MENU", Toast.LENGTH_LONG).show();
                            break;
            case R.id.guide:Toast.makeText(gridDemo.this,"Guiding CONTEXT MENU", Toast.LENGTH_LONG).show();
                break;
        }
        return true;
    }

}

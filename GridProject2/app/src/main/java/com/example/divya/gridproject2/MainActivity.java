package com.example.divya.gridproject2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import static com.example.divya.gridproject2.R.drawable.image1;

public class MainActivity extends Activity {
    public static  String EXTRA_RES_ID ="POS";
    public static  String POS = null;
    public boolean b=false;
    public static  long idMain;

    //Have the image ids in a arrayList which can be used as references for the images in the project.
    private ArrayList<Integer> mThumbCarIds=new ArrayList<Integer>(Arrays.asList(image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,R.drawable.image5,
            R.drawable.image6,R.drawable.image7,R.drawable.image8,R.drawable.image9,R.drawable.image10,R.drawable.image11,R.drawable.image12));
    //Name of the cars stored as a string array
    String[] web = {
            "HONDA",
            "LINCOLN",
    "FORD",
    "NISSAN",
    "CHRYSLER",
    "DODGE",
    "TESLA",
            "BMW","MERCEDES BENZ","GMC","JEEP","TOYOTA"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Setting the layout for the MainActivity
        setContentView(R.layout.main);
        //Getting the gridView of the layout
        GridView gridView=(GridView)findViewById(R.id.gv1);
        //Registering the gridView for the ContextMenu
        registerForContextMenu(gridView);

        //Setting the image adapter for the gridView using the ImageAdapter Class
        gridView.setAdapter(new ImageAdapter(this,mThumbCarIds,web));
        //Setting onItemClickListener for the short click on the grid items to display the image in a new Activity called ImageActivity
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            public void onItemClick(AdapterView<?> parent, View v,int position,long id){
                Intent intent=new Intent(MainActivity.this,ImageActivity.class);
               // idMain=id;

                intent.putExtra(EXTRA_RES_ID, (int)id ); //Adding the id of the gridItem
                intent.putExtra(POS,position); //Adding the position of the gridItem
                startActivity(intent); //Start the intent to invoke the new activity

            }
        });



    }


    // Create Context Menu which will be displayed when grid items are long clicked
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
      //Call the super class constructor
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context Menu");
        //The different options on the context menu

        menu.add(0, v.getId(), 0, "View Picture");
        menu.add(0, v.getId(), 0, "Manufacture's official website");
        menu.add(0, v.getId(), 0, "Dealers");
    }

    //Once the option in the context menu gets clicked the following fuction is called
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        long index = info.id;

        int position =info.position;
        //Based on the item's title we choose the function
        if(item.getTitle()=="View Picture"){function1(index,position);}
        else if(item.getTitle()=="Manufacture's official website"){function2(position);}
        else if(item.getTitle()=="Dealers"){function3(position);}
        else {return false;}
        return true;
    }
    //This is the function called when the "View Picture" context menu option is selected
   public void function1(long res_id,int position){
       Intent intent=new Intent(MainActivity.this,ImageActivity.class);//calls the ImageActivity class to display the picture
       intent.putExtra(EXTRA_RES_ID,(int)res_id);//adds the id of the grid item to the intent's extra EXTRA_RES_ID
       intent.putExtra(POS,position);//also adds the position of the grid item to the intent's extra POS
       startActivity(intent);//Start Activity


   }
    public void function2(int position){
        Intent intent=new Intent(MainActivity.this,veiwOfficialWebsiteActivity.class);//Starting a new activity for displaying the officialWebsite of the cars
        intent.putExtra(POS,position);//We have this extra because , it would be easier for us to retrieve the offical website of cars.As they are stored in a string array in the viewOfficialWebsiteActivity activity
        startActivity(intent);//Start Activity

    }
    public void function3(int position){
        Intent intent=new Intent(MainActivity.this,listViewAdapter.class);//This calls the listViewAdapter activity for displayig
        intent.putExtra(POS,position);//Uses the position of grid item for displaying the dealer's list
        startActivity(intent);//Start Activity

    }

}

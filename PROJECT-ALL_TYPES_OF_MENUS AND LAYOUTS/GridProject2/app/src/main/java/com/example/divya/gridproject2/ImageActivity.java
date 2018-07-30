package com.example.divya.gridproject2;

/**
 * Created by DIVYA on 10/1/2017.
 */

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.divya.gridproject2.MainActivity.EXTRA_RES_ID;
import static com.example.divya.gridproject2.MainActivity.POS;

/**
 * Created by DIVYA on 10/1/2017.
 */

public class ImageActivity extends Activity {
    //urlArray is the String array of the websites of the car brands.
    // Stored in the order in which they are displayed on the grid view
    String[] urlArray={"http://www.honda.com" +
            "/",
            "http://www.lincoln.com/",
            "http://www.ford.com/",
            "http://www.nissanusa.com/",
            "http://www.chrysler.com/",
            "http://www.dodge.com/",
            "http://www.tesla.com/",
            "http://www.bmwusa.com/",
            "http://www.mbusa.com/",
            "http://www.gmc.com/",
            "http://www.jeep.com/",
            "http://www.toyota.com/"
    };
    String url=null;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent i=getIntent();  //get the intent that started this activity
        //Create a new imageView
        ImageView imageView=new ImageView(getApplicationContext());
        //Get the id of the image to be displayed. Set that image as the image for the image view
        imageView.setImageResource(i.getIntExtra(EXTRA_RES_ID,0));
        //Inorder to display the official website of the brand when the picture is clicked we do the following
        //retrieve the url to be browsed from the urlArray.
        //urlArray is a string array with all the websites as strings
        //Depending on the position we set the url string
        url=urlArray[i.getIntExtra(POS,0)];
        setContentView(imageView);

        //Setting the onClickListener to view the website in the browser
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);//Since the action of the intent is viewing, we use ACTION_VIEW
                intent.addCategory(Intent.CATEGORY_BROWSABLE);//The main intention of this intent is to browse a website so we used CATEGORY_BROWSABLE
                intent.setData(Uri.parse(url));//Setting the data of the intent to the url
                startActivity(intent);//Start the Activity


            }
        });

    }
}

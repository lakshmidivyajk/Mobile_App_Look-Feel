package com.example.divya.gridproject2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import static com.example.divya.gridproject2.MainActivity.EXTRA_RES_ID;
import static com.example.divya.gridproject2.MainActivity.POS;

/**
 * Created by DIVYA on 10/2/2017.
 */

public class veiwOfficialWebsiteActivity extends Activity {
    //urlArray is the String array of the websites of the car brands.
    // Stored in the order in which they are displayed on the grid view
    String[] urlArray={"http://www.honda.com/",
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
        Intent i=getIntent();//get the intent
        url=urlArray[i.getIntExtra(POS,0)];//get the position from the intent, then get the url from the urlArray based on the POS extra
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);//ACTION_VIEW is used for viewing the intent
        intent.addCategory(Intent.CATEGORY_BROWSABLE);//Since we need to browse a website we are using the CATEGORY_BROWSABLE
        intent.setData(Uri.parse(url));//url is set to the data of the intent
        startActivity(intent);//Start activity
        finish();

    }
}

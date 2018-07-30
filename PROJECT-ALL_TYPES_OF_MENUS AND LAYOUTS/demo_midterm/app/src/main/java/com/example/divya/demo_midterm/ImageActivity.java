package com.example.divya.demo_midterm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by DIVYA on 10/11/2017.
 */

public class ImageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent i=getIntent();

        ImageView iv= new ImageView(getApplicationContext());


    }
}

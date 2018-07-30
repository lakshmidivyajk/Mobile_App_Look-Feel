package com.example.divya.demo_midterm;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    CheckBox cb1;
    TextView tv;
    Button b1,b2;
    //Boolean finishedActivityonSaveCompleted;

   @Override
    protected void onCreate(Bundle savedInstanceState){
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
       cb1=(CheckBox)findViewById(R.id.cb1);
       tv=(TextView)findViewById(R.id.tv);
       tv.setText("null");
       cb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
           @Override
           public void onCheckedChanged(CompoundButton buttonView,boolean isChecked){
               if(isChecked)
               {
                   cb1.setText("Checked");
               }
               else{
                   cb1.setText("not Checked");
               }

           }
       });

       b1=(Button)findViewById(R.id.b1);
       b1.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
               Toast.makeText(MainActivity.this,"button",Toast.LENGTH_LONG).show();
             Intent intent=new Intent(MainActivity.this,listDemo.class);
               startActivity(intent);

           }
       });
       b2=(Button)findViewById(R.id.b2);
       b2.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v){
              // Toast.makeText(MainActivity.this,"button",Toast.LENGTH_LONG).show();
               Intent intent=new Intent(MainActivity.this,gridDemo.class);
               startActivity(intent);

           }
       });

     /*  Intent i=new Intent(Intent.ACTION_INSERT, ContactsContract.Contacts.CONTENT_URI);
       i.putExtra("finishActivityOnSaveCompleted",true);
       startActivityForResult(i,1);*/


   }
  /* public void onActivityResult(int requestCode,int resultCode,Intent data){
       super.onActivityResult(requestCode,resultCode,data);
       if(requestCode==1){
           if(resultCode==RESULT_OK){
               tv.setText("SUCCESS");

           }else if(resultCode==RESULT_CANCELED){
               tv.setText("FAILURE");
           }
       }
   }*/
  @Override
  public boolean onCreateOptionsMenu(Menu menu){
      MenuInflater inflater=getMenuInflater();
      inflater.inflate(R.menu.menu_main,menu);
      return true;
  }
  @Override
    public boolean onOptionsItemSelected(MenuItem menuItem){
      switch(menuItem.getItemId()){
          case R.id.help:{Toast.makeText(MainActivity.this,"Helping",Toast.LENGTH_LONG).show();
               }break;
          case R.id.guide:{Toast.makeText(MainActivity.this,"Guiding",Toast.LENGTH_LONG).show();
              }break;

      }
      return true;


  }
}

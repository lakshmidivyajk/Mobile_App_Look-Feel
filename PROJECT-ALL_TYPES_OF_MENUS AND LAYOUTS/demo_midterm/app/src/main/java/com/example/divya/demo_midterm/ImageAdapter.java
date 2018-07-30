package com.example.divya.demo_midterm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by DIVYA on 10/11/2017.
 */

public class ImageAdapter extends BaseAdapter{
    private final int PADDING=8;
    private final int ht=250;
    private final int wt=250;
     Context mContext;
    List<Integer> mCars;
   String[] carNames;

    public ImageAdapter(Context mC,List<Integer>carId,String[] cn){
        this.mContext=mC;
        this.mCars=carId;
        this.carNames=cn;

    }
    @Override
    public int getCount(){
        return mCars.size();
    }
    @Override
    public long getItemId(int position){
        return mCars.get(position);
    }
    @Override
    public Object getItem(int position){
        return mCars.get(position);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View g;
        LayoutInflater inflater=(LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            g=new View(mContext);

            g=inflater.inflate(R.layout.griddemo,null);
            TextView tv=(TextView)g.findViewById(R.id.gridTV);
            ImageView iv=(ImageView)g.findViewById(R.id.imageGrid);
            tv.setText(carNames[position]);
            iv.setImageResource(mCars.get(position));

        }else{
            g=(View)convertView;
        }
        return g;



    }

}

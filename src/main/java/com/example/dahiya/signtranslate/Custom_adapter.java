package com.example.dahiya.signtranslate;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom_adapter extends ArrayAdapter<String>  {

    Context context;
    String arr[];
    LayoutInflater inflater;
    public Custom_adapter(@NonNull Context context, @NonNull String[] p) {
        super(context, R.layout.custom_row, p);

//        this.context=context;
        this.arr=p;
    }

//    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//
//
//
//        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        convertView=inflater.inflate(R.layout.custom_row,null);
//
//        TextView textView=(TextView)convertView.findViewById(R.id.textView);
//
//        textView.setText(arr[position]);
//
//        return convertView;
//    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // default -  return super.getView(position, convertView, parent);
        // add the layout
        LayoutInflater myCustomInflater = LayoutInflater.from(getContext());
        View customView = myCustomInflater.inflate(R.layout.custom_row, parent, false);
        // get references.
        //String singleFoodItem = getItem(position);
        TextView textView = (TextView) customView.findViewById(R.id.textView);


        // dynamically update the text from the array
        textView.setText(arr[position]);

        return customView;
    }
}

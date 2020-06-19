package com.example.agrismart;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class RisorseListAdapter extends ArrayAdapter<Risorse> {

    private final Activity context;


    public RisorseListAdapter(Activity context, ArrayList<Risorse> risorse) {
        super(context, R.layout.listview_risorse, risorse);
        // TODO Auto-generated constructor stub
        this.context=context;


    }

    @NonNull
    @Override
    public View getView(int position,View view,ViewGroup parent) {
        String title = getItem(position).getTitle();
        String quantity = getItem(position).getQuantity();

        Risorse r = new Risorse(title, quantity);
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_risorse, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView qtyText = (TextView) rowView.findViewById(R.id.quantity);

        titleText.setText(title);
        qtyText.setText(quantity);

        return rowView;




    };
}
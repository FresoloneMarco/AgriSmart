package com.example.agrismart;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<Products> {

    private final Activity context;


    public MyListAdapter(Activity context, ArrayList<Products> prodotti) {
        super(context, R.layout.listview_raccolto, prodotti);
        // TODO Auto-generated constructor stub
        this.context=context;


    }

    @NonNull
    @Override
    public View getView(int position,View view,ViewGroup parent) {
        String title = getItem(position).getTitle();
        String subTitle = getItem(position).getSubtitle();
        String quantity = getItem(position).getQuantity();

        Products p = new Products(title,subTitle,quantity);
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_raccolto, null,true);

        TextView titleText = (TextView) rowView.findViewById(R.id.title);
        TextView subText = (TextView) rowView.findViewById(R.id.subtitle);
        TextView qtyText = (TextView) rowView.findViewById(R.id.quantity);

        titleText.setText(title);
        subText.setText(subTitle);
        qtyText.setText(quantity);

        return rowView;




    };
}
package com.example.agrismart;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ChatListAdapter extends ArrayAdapter<String> {

    private final Activity context;


    public ChatListAdapter(Activity context, ArrayList<String> messaggi) {
        super(context, R.layout.listview_membri, messaggi);
        // TODO Auto-generated constructor stub
        this.context=context;


    }

    @NonNull
    @Override
    public View getView(int position,View view,ViewGroup parent) {
        String text = getItem(position).toString();

        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_messaggi, null,true);

        TextView sent = (TextView) rowView.findViewById(R.id.sent);
        TextView received = (TextView) rowView.findViewById(R.id.received);


        sent.setText(text);
        received.setText("Grandi ragazzi meritate 30L !");


        return rowView;




    };
}
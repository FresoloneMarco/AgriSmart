package com.example.agrismart;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class ConcimeListAdapter extends ArrayAdapter<Concime> {

    private final Activity context;


    public ConcimeListAdapter(Activity context, ArrayList<Concime> concimi) {
        super(context, R.layout.listview_raccolto, concimi);
        // TODO Auto-generated constructor stub
        this.context=context;


    }

    @NonNull
    @Override
    public View getView(int position,View view,ViewGroup parent) {
        String nome = getItem(position).getNome();
        int max_qty = getItem(position).getMax_qty();
        int qty = getItem(position).getQty();

        Concime c = new Concime(nome, max_qty, qty);
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_concimi, null,true);

        TextView nomeConcime = (TextView) rowView.findViewById(R.id.nome_concime);
        TextView qtyConcime = (TextView) rowView.findViewById(R.id.qty_concime);
        ProgressBar progressBar = (ProgressBar) rowView.findViewById(R.id.progress_concime);

        nomeConcime.setText(nome);
        qtyConcime.setText(String.valueOf(qty) + "/" + String.valueOf(max_qty) + " KGs");
        progressBar.setProgress(qty*100/max_qty);

        return rowView;




    };
}
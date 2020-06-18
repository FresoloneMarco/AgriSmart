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

public class SemeListAdapter extends ArrayAdapter<Seme> {

    private final Activity context;


    public SemeListAdapter(Activity context, ArrayList<Seme> semi){
        super(context, R.layout.listview_raccolto, semi);
        // TODO Auto-generated constructor stub
        this.context=context;


    }

    @NonNull
    @Override
    public View getView(int position,View view,ViewGroup parent) {
        String nome = getItem(position).getNome();
        int max_qty = getItem(position).getMax_qty();
        int qty = getItem(position).getQty();

        Seme s = new Seme(nome, max_qty, qty);
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_semi, null,true);

        TextView nomeSeme = (TextView) rowView.findViewById(R.id.nome_seme);
        TextView qtySeme = (TextView) rowView.findViewById(R.id.qty_seme);
        ProgressBar progressBar = (ProgressBar) rowView.findViewById(R.id.progress_seme);

        nomeSeme.setText(nome);
        qtySeme.setText(String.valueOf(qty) + "/" + String.valueOf(max_qty) + " KGs");
        progressBar.setProgress(qty*100/max_qty);

        return rowView;




    };
}
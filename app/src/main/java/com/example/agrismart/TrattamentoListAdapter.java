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

public class TrattamentoListAdapter extends ArrayAdapter<Trattamento> {

    private final Activity context;


    public TrattamentoListAdapter(Activity context, ArrayList<Trattamento> trattamenti) {
        super(context, R.layout.listview_raccolto, trattamenti);
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
        View rowView=inflater.inflate(R.layout.listview_trattamenti, null,true);

        TextView nomeTrattamento = (TextView) rowView.findViewById(R.id.nome_trattamento);
        TextView qtyTrattamento = (TextView) rowView.findViewById(R.id.qty_trattamento);
        ProgressBar progressBar = (ProgressBar) rowView.findViewById(R.id.progress_trattamento);

        nomeTrattamento.setText(nome);
        qtyTrattamento.setText(String.valueOf(qty) + "/" + String.valueOf(max_qty) + " KGs");
        progressBar.setProgress(qty*100/max_qty);

        return rowView;




    };
}
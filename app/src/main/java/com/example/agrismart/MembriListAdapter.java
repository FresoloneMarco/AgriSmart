package com.example.agrismart;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class MembriListAdapter extends ArrayAdapter<Membro> {

    private final Activity context;


    public MembriListAdapter(Activity context, ArrayList<Membro> membri) {
        super(context, R.layout.listview_membri, membri);
        // TODO Auto-generated constructor stub
        this.context=context;


    }

    @NonNull
    @Override
    public View getView(int position,View view,ViewGroup parent) {
        String nome = getItem(position).getNome();
        String cognome = getItem(position).getCognome();

        Membro m = new Membro(nome, cognome);
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_membri, null,true);

        TextView cognomeTv = (TextView) rowView.findViewById(R.id.nome_dipendente);
        TextView nomeTv = (TextView) rowView.findViewById(R.id.cognome_dipendente);


        cognomeTv.setText(cognome);
        nomeTv.setText(nome);


        return rowView;




    };
}
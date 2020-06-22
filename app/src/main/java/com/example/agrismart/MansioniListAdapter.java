package com.example.agrismart;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.agrismart.fragments.DescrizioneMansioneFragment;
import com.example.agrismart.fragments.ProfiloFragment;
import com.example.agrismart.fragments.SerraContentFragment;

import java.util.ArrayList;

public class MansioniListAdapter extends ArrayAdapter<Mansione>{

    private final Activity context;


    public MansioniListAdapter(Activity context, ArrayList<Mansione> mansioni) {
        super(context, R.layout.listview_mansioni, mansioni);
        // TODO Auto-generated constructor stub
        this.context=context;


    }

    @NonNull
    @Override
    public View getView(int position,View view,ViewGroup parent) {
        final String nome = getItem(position).getNome();
        final String descrizione = getItem(position).getDescrizione();
        String serra = getItem(position).getSerra();

        Mansione m = new Mansione(nome, descrizione, serra);
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_mansioni, null,true);


        TextView nomeMansione = (TextView) rowView.findViewById(R.id.title_card1);
        TextView descrizioneMansione = (TextView) rowView.findViewById(R.id.subtitle_card1);
        Button buttonSerra = (Button) rowView.findViewById(R.id.bt_serra_card1);
        Button buttonLeggi = (Button) rowView.findViewById(R.id.bt_read_card1);

        nomeMansione.setText(nome);
        descrizioneMansione.setText(descrizione);


        buttonLeggi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("nome", nome);
                bundle.putString("descrizione", descrizione);
                FragmentManager fm = ((FragmentActivity)context).getSupportFragmentManager();
                DescrizioneMansioneFragment nuovo= new DescrizioneMansioneFragment();
                nuovo.setArguments(bundle);
                fm.beginTransaction().replace(R.id.fragment_container, nuovo).commit();
            }
        });

        buttonSerra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = ((FragmentActivity)context).getSupportFragmentManager();
                SerraContentFragment nuovo= new SerraContentFragment();
                fm.beginTransaction().replace(R.id.fragment_container, nuovo).commit();
            }
        });

        return rowView;




    };
}
package com.example.agrismart.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.agrismart.AlertDialog;
import com.example.agrismart.MyListAdapter;
import com.example.agrismart.Products;
import com.example.agrismart.R;

import java.util.ArrayList;

public class RaccoltoFragment extends Fragment {
    private ListView list;
    private ArrayList<Products> prodotti;
    private Button addButton, consegnaButton;
    private Spinner ortaggi;
    private Spinner serre;
    private EditText qty;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_raccolto, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Raccolto");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(false);

        prodotti = new ArrayList<Products>();
        addButton = view.findViewById(R.id.button14);
        consegnaButton = view.findViewById(R.id.invia_consegna);
        ortaggi = view.findViewById(R.id.spinner3);
        serre = view.findViewById(R.id.spinner5);
        qty = view.findViewById(R.id.editTextTextPersonName5);
        list = view.findViewById(R.id.listview_raccolto);
        final MyListAdapter adapter = new MyListAdapter((Activity) view.getContext(), prodotti);
        list = view.findViewById(R.id.listview_raccolto);
        list.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ortaggi.getSelectedItem() == null || serre.getSelectedItem() == null || qty.getText().toString().equals("")){
                    AlertDialog alertDialog = new AlertDialog("Errore", "Compilare tutti i campi.", "Ok", "");
                    alertDialog.show(getFragmentManager(), "example dialog");
                } else {
                    String ortaggio = ortaggi.getSelectedItem().toString();
                    String serra = serre.getSelectedItem().toString();
                    String quantità = qty.getText().toString() + "KG";

                    Products p = new Products(ortaggio, serra, quantità);
                    prodotti.add(p);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        consegnaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(prodotti.isEmpty()){
                    AlertDialog alertDialog = new AlertDialog("Errore", "Non sono presenti prodotti da consegnare.", "Ok", "");
                    alertDialog.show(getFragmentManager(), "example dialog");
                }
                else{
                    AlertDialog alertDialog = new AlertDialog("Attenzione", "Confermare l'invio della consegna ?", "Si", "No");
                    alertDialog.show(getFragmentManager(), "example dialog");
                }
            }
        });
        return view;
    }
}


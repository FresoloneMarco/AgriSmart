package com.example.agrismart.fragments;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.agrismart.Concime;
import com.example.agrismart.MyListAdapter;
import com.example.agrismart.R;
import com.example.agrismart.Risorse;
import com.example.agrismart.RisorseListAdapter;
import com.example.agrismart.Seme;
import com.example.agrismart.Trattamento;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ResocontoMansioneFragment extends Fragment {

    private Spinner spinner_risorse;
    private ArrayList<Concime> concimi;
    private ArrayList<Trattamento> trattamenti;
    private ArrayList<Seme> semi;
    private ListView list;
    private Button addButton;
    private EditText qty;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completa_mansione, container, false);

        /* RETRIEVE DATI DA SHARED PREFERENCES */
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        Gson gson = new Gson();
        String concimiJson = sharedPreferences.getString("concimi", "");
        String trattamentiJson = sharedPreferences.getString("trattamenti", "");
        String semiJson = sharedPreferences.getString("semi", "");
        Type typeConcimi = new TypeToken<ArrayList<Concime>>() {}.getType();
        Type typeSemi = new TypeToken<ArrayList<Seme>>() {}.getType();
        Type typeTrattamenti = new TypeToken<ArrayList<Trattamento>>() {}.getType();
        concimi = gson.fromJson(concimiJson, typeConcimi);
        trattamenti = gson.fromJson(trattamentiJson, typeTrattamenti);
        semi = gson.fromJson(semiJson, typeSemi);
        /* FINE RETRIEVE */



        spinner_risorse = view.findViewById(R.id.spinner_risorse);
        ArrayList<String> spinnerEntries = new ArrayList<>();

        for(Concime c : concimi){
            spinnerEntries.add(c.getNome());
        }
        for (Trattamento t : trattamenti){
            spinnerEntries.add(t.getNome());
        }
        for(Seme s : semi){
            spinnerEntries.add(s.getNome());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_spinner_item, spinnerEntries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_risorse.setAdapter(adapter);


        final ArrayList<Risorse> risorse = new ArrayList<Risorse>();
        list = view.findViewById(R.id.listview_risorse);
        final RisorseListAdapter risorseListAdapter = new RisorseListAdapter((Activity) view.getContext(), risorse);
        list.setAdapter(risorseListAdapter);

        addButton = view.findViewById(R.id.button_aggiungi);
        qty = view.findViewById(R.id.editText_peso);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Risorse r = new Risorse(spinner_risorse.getSelectedItem().toString(), qty.getText().toString());
                risorse.add(r);
                risorseListAdapter.notifyDataSetChanged();
            }
        });
        return view;
    }
}

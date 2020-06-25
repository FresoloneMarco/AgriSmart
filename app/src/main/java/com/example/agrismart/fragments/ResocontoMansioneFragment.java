package com.example.agrismart.fragments;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Debug;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.example.agrismart.AlertDialog;
import com.example.agrismart.AlertDialog_CompletaMansione;
import com.example.agrismart.Concime;
import com.example.agrismart.Mansione;
import com.example.agrismart.MyListAdapter;
import com.example.agrismart.R;
import com.example.agrismart.Risorse;
import com.example.agrismart.RisorseListAdapter;
import com.example.agrismart.Seme;
import com.example.agrismart.Trattamento;
import com.example.agrismart.Utente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ResocontoMansioneFragment extends Fragment {

    private TextView descrizione_tv;
    private Spinner spinner_risorse;
    private static ArrayList<Concime> concimi;
    private static ArrayList<Trattamento> trattamenti;
    private static ArrayList<Seme> semi;
    private static ArrayList<Risorse> risorse;
    private ListView list;
    private Button addButton, consegnaButton;
    private EditText qty;
    private static Gson gson;
    private static SharedPreferences.Editor editor;
    private static RisorseListAdapter risorseListAdapter;
    public static boolean consegnato = false;
    private Utente loggedUser;
    private static View view;
    private static String nomeMansione;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_completa_mansione, container, false);
        consegnaButton = view.findViewById(R.id.invia_consegna);
        descrizione_tv = view.findViewById(R.id.descrizone_tv);
        nomeMansione = this.getArguments().getString("nome");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(nomeMansione);
        String descrizione = this.getArguments().getString("descrizione");
        descrizione_tv.setText(descrizione);

        /* RETRIEVE DATI DA SHARED PREFERENCES */
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        gson = new Gson();
        editor = sharedPreferences.edit();
        String concimiJson = sharedPreferences.getString("concimi", "");
        String trattamentiJson = sharedPreferences.getString("trattamenti", "");
        String semiJson = sharedPreferences.getString("semi", "");
        Type typeConcimi = new TypeToken<ArrayList<Concime>>() {
        }.getType();
        Type typeSemi = new TypeToken<ArrayList<Seme>>() {
        }.getType();
        Type typeTrattamenti = new TypeToken<ArrayList<Trattamento>>() {
        }.getType();
        concimi = gson.fromJson(concimiJson, typeConcimi);
        trattamenti = gson.fromJson(trattamentiJson, typeTrattamenti);
        semi = gson.fromJson(semiJson, typeSemi);
        /* FINE RETRIEVE */


        spinner_risorse = view.findViewById(R.id.spinner_risorse);
        ArrayList<String> spinnerEntries = new ArrayList<>();

        for (Concime c : concimi) {
            spinnerEntries.add(c.getNome());
        }
        for (Trattamento t : trattamenti) {
            spinnerEntries.add(t.getNome());
        }
        for (Seme s : semi) {
            spinnerEntries.add(s.getNome());
        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(),
                android.R.layout.simple_spinner_item, spinnerEntries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_risorse.setAdapter(adapter);


        risorse = new ArrayList<Risorse>();
        list = view.findViewById(R.id.listview_risorse);
        risorseListAdapter = new RisorseListAdapter((Activity) view.getContext(), risorse);
        list.setAdapter(risorseListAdapter);

        addButton = view.findViewById(R.id.button_aggiungi);
        qty = view.findViewById(R.id.editText_peso);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean addable = true;
                Risorse r = new Risorse(spinner_risorse.getSelectedItem().toString(), qty.getText().toString());
                for (Concime c : concimi) {
                    if (c.getNome().equals(r.getTitle()) && c.getQty() < Integer.parseInt(r.getQuantity())) {
                        AlertDialog_CompletaMansione alertDialog = new AlertDialog_CompletaMansione("Errore", "In magazzino sono presenti solo " + String.valueOf(c.getQty()) + " KG di " + c.getNome() + ".", "Ok", "");
                        alertDialog.show(getFragmentManager(), "example dialog");
                        addable = false;
                    }
                }
                for (Trattamento t : trattamenti) {
                    if (t.getNome().equals(r.getTitle()) && t.getQty() < Integer.parseInt(r.getQuantity())) {
                        AlertDialog_CompletaMansione alertDialog = new AlertDialog_CompletaMansione("Errore", "In magazzino sono presenti solo " + String.valueOf(t.getQty()) + " KG di " + t.getNome() + ".", "Ok", "");
                        alertDialog.show(getFragmentManager(), "example dialog");
                        addable = false;
                    }
                }
                for (Seme s : semi) {
                    if (s.getNome().equals(r.getTitle()) && s.getQty() < Integer.parseInt(r.getQuantity())) {
                        AlertDialog_CompletaMansione alertDialog = new AlertDialog_CompletaMansione("Errore", "In magazzino sono presenti solo " + String.valueOf(s.getQty()) + " KG di " + s.getNome() + ".", "Ok", "");
                        alertDialog.show(getFragmentManager(), "example dialog");
                        addable = false;
                    }
                }

                if(addable == true)
                    risorse.add(r);

                risorseListAdapter.notifyDataSetChanged();
            }
        });

        consegnaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog_CompletaMansione alertDialog = new AlertDialog_CompletaMansione("Attenzione", "Completare la mansione ?", "Si", "No");
                alertDialog.show(getFragmentManager(), "example dialog");
            }
        });





        return view;
    }

    public static void consegna(ArrayList<Risorse> risorse) {

        int i = 0;
        for (Risorse r : risorse) {
            for (Concime c : concimi) {
                if (c.getNome().equals(r.getTitle())) {
                    c.setQty(c.getQty() - Integer.parseInt(r.getQuantity()));
                    concimi.set(i, c);
                    String jsonConcimi = gson.toJson(concimi);
                    editor.putString("concimi", jsonConcimi);
                    editor.commit();
                }
                i++;
            }

            i = 0;
            for (Trattamento t : trattamenti) {
                if (t.getNome().equals(r.getTitle())) {
                    t.setQty(t.getQty() - Integer.parseInt(r.getQuantity()));
                    trattamenti.set(i, t);
                    String jsonTrattamenti = gson.toJson(trattamenti);
                    editor.putString("trattamenti", jsonTrattamenti);
                    editor.commit();
                }
                i++;
            }

            i = 0;
            for (Seme s : semi) {
                if (s.getNome().equals(r.getTitle())) {
                    s.setQty(s.getQty() - Integer.parseInt(r.getQuantity()));
                    semi.set(i, s);
                    String jsonSemi = gson.toJson(semi);
                    editor.putString("semi", jsonSemi);
                    editor.commit();
                }
                i++;
            }

        }
        risorse.clear();
        risorseListAdapter.notifyDataSetChanged();
        consegnato = true;
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        gson = new Gson();
        String loggedUserJson = sharedPreferences.getString("loggedUser", "");
        Type typeUtente = new TypeToken<Utente>() {
        }.getType();
        Utente loggedUser = gson.fromJson(loggedUserJson, typeUtente);
        int r = 0;
        int j = 0;
        for(Mansione m : loggedUser.getMansioni()){
            if(m.getNome().equals(nomeMansione)){
                r = j;
            }
            j++;
        }
        loggedUser.getMansioni().remove(r);
        String jsonLoggedUser = gson.toJson(loggedUser);
        editor.putString("loggedUser", jsonLoggedUser);
        editor.commit();

        FragmentActivity activity = (FragmentActivity)view.getContext();
        FragmentManager manager = activity.getSupportFragmentManager();
        HomeFragment nuovo = new HomeFragment();
        manager.beginTransaction().replace(R.id.fragment_container, nuovo).commit();
    }


    public static void scelta(Boolean scelta){
        if (scelta == true) {
            consegna(risorse);
        } else {
        }
    }






}





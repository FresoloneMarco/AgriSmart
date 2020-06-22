package com.example.agrismart.fragments;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.agrismart.Mansione;
import com.example.agrismart.MansioniListAdapter;
import com.example.agrismart.MembriListAdapter;
import com.example.agrismart.Membro;
import com.example.agrismart.R;
import com.example.agrismart.Risorse;
import com.example.agrismart.RisorseListAdapter;
import com.example.agrismart.Utente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private ListView list;
    private ArrayList<Mansione> mansioni;
    private Gson gson;
    private SharedPreferences.Editor editor;
    private Utente loggedUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        mansioni = new ArrayList<>();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        gson = new Gson();
        editor = sharedPreferences.edit();
        String loggedUserJson = sharedPreferences.getString("loggedUser", "");
        Type typeUtente = new TypeToken<Utente>() {
        }.getType();
        loggedUser = gson.fromJson(loggedUserJson, typeUtente);

        mansioni = loggedUser.getMansioni();

        if(loggedUser.getRole().equals("admin")){
            list = view.findViewById(R.id.listview_mansioni);

            ImageView headerUser = view.findViewById(R.id.imageView4);
            headerUser.setVisibility(View.GONE);

            ImageView subTitleUser = view.findViewById(R.id.imageView5);
            subTitleUser.setVisibility(View.GONE);
            ArrayList<Membro> membri = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Membro m = new Membro("Dipendente " + i, "Cognome " + i);
                membri.add(m);
            }
            final MembriListAdapter adapter = new MembriListAdapter((Activity) view.getContext(), membri);
            list.setAdapter(adapter);

        } else {
            list = view.findViewById(R.id.listview_mansioni);
            final MansioniListAdapter mansioniListAdapter = new MansioniListAdapter((Activity) view.getContext(), mansioni);
            list.setAdapter(mansioniListAdapter);
            mansioniListAdapter.notifyDataSetChanged();
        }

        return view;
    }

    public void readDescr(){
        DescrizioneMansioneFragment nuovo= new DescrizioneMansioneFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();
    }




}

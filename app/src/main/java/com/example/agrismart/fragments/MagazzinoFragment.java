package com.example.agrismart.fragments;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.agrismart.Concime;
import com.example.agrismart.ConcimeListAdapter;
import com.example.agrismart.R;
import com.example.agrismart.Seme;
import com.example.agrismart.SemeListAdapter;
import com.example.agrismart.Trattamento;
import com.example.agrismart.TrattamentoListAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MagazzinoFragment extends Fragment {
    private ListView list,list2,list3;
    private ArrayList<Concime> concimi;
    private ArrayList<Trattamento> trattamenti;
    private ArrayList<Seme> semi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_magazzino, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Magazzino");
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


        final ConcimeListAdapter adapter = new ConcimeListAdapter((Activity) view.getContext(), concimi);
        list = view.findViewById(R.id.concimi_lv);
        list.setAdapter(adapter);

        final TrattamentoListAdapter adapter2 = new TrattamentoListAdapter((Activity) view.getContext(), trattamenti);
        list2 = view.findViewById(R.id.trattamenti_lv);
        list2.setAdapter(adapter2);

        final SemeListAdapter adapter3 = new SemeListAdapter((Activity) view.getContext(), semi);
        list3 = view.findViewById(R.id.semi_lv);
        list3.setAdapter(adapter3);
        return  view;
    }
}

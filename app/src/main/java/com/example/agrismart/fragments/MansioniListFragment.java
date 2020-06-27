package com.example.agrismart.fragments;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.agrismart.Mansione;
import com.example.agrismart.MansioniListAdapter;
import com.example.agrismart.R;
import com.example.agrismart.Utente;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Calendar;

public class MansioniListFragment extends Fragment  {
    private ListView list;
    private ArrayList<Mansione> mansioni;
    private Gson gson;
    private SharedPreferences.Editor editor;
    private Utente loggedUser;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mansionilist, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Mansioni");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(false);

        mansioni = new ArrayList<>();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(view.getContext());
        gson = new Gson();
        editor = sharedPreferences.edit();
        String loggedUserJson = sharedPreferences.getString("loggedUser", "");
        Type typeUtente = new TypeToken<Utente>() {
        }.getType();
        loggedUser = gson.fromJson(loggedUserJson, typeUtente);

        mansioni = loggedUser.getMansioni();

        list = view.findViewById(R.id.listview_prossimeMansioni);
        final MansioniListAdapter mansioniListAdapter = new MansioniListAdapter((Activity) view.getContext(), mansioni);
        list.setAdapter(mansioniListAdapter);
        mansioniListAdapter.notifyDataSetChanged();
        return view;
    }


}

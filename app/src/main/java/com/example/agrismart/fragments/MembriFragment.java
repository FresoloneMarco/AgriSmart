package com.example.agrismart.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.agrismart.HomeUser;
import com.example.agrismart.MembriListAdapter;
import com.example.agrismart.Membro;
import com.example.agrismart.MyListAdapter;
import com.example.agrismart.R;

import java.util.ArrayList;
import java.util.List;

public class MembriFragment extends Fragment {
    private ListView list;
    private ArrayList<Membro> membri;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_membri, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Membri");
        membri = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Membro m = new Membro("Dipendente " + i, "Cognome " + i);
            membri.add(m);
        }
        list = view.findViewById(R.id.listViewMembri);
        final MembriListAdapter adapter = new MembriListAdapter((Activity) view.getContext(), membri);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adattatore, final View componente, int pos, long id){
                final Membro m = (Membro) adattatore.getItemAtPosition(pos);
                Bundle bundle = new Bundle();
                bundle.putString("nome", m.getNome());
                ProfiloFragment nuovo= new ProfiloFragment();
                nuovo.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();
            }
        });


                return view;
            }


        }

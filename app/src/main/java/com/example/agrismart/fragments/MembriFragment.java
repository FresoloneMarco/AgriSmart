package com.example.agrismart.fragments;

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
import androidx.fragment.app.Fragment;

import com.example.agrismart.HomeUser;
import com.example.agrismart.R;

import java.util.ArrayList;

public class MembriFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_membri, container, false);
        String[] membri;
        membri = new String[] { "Apicella", "Barone", "Civale" };


        ListView mylist = (ListView) view.findViewById(R.id.listView1);
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, membri);
        mylist.setAdapter(adapter);


        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adattatore, final View componente, int pos, long id){
                final String nome = (String) adattatore.getItemAtPosition(pos);
                Bundle bundle = new Bundle();
                bundle.putString("nome", nome);
                ProfiloFragment nuovo= new ProfiloFragment();
                nuovo.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();



            }
        });
        return view;
    }


}

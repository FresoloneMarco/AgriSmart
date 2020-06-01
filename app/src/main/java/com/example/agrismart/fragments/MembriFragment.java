package com.example.agrismart.fragments;

import android.content.Intent;
import android.os.Bundle;
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
        String[] membri;
        membri = new String[] { "Apicella", "Barone", "Civale" };
        final ArrayList<String> listp = new ArrayList<String>();
        for (int i = 0; i < membri.length; ++i) {
            listp.add(membri[i]);
        }
        final ListView mylist = (ListView) getView().findViewById(R.id.listView1);
        final ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.fragment_membri, listp);
        mylist.setAdapter(adapter);

        mylist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adattatore, final View componente, int pos, long id){


            }
        });
        return inflater.inflate(R.layout.fragment_membri, container, false);
    }


}

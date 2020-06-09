package com.example.agrismart.fragments;

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

import com.example.agrismart.R;

public class SerreFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_serre, container, false);
        ListView listView= (ListView) view.findViewById(R.id.listaSerreView);
        String[] serre= new String[] {"Serra 1", "Serra 2", "Serra 3", "Serra 4", "Serra 5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, serre);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String nome = (String) parent.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putString("nome", nome);
                SerraContentFragment nuovo= new SerraContentFragment();
                nuovo.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();
            }
        });

        return view;
    }
}

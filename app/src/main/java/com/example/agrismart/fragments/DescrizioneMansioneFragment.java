package com.example.agrismart.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.agrismart.R;

public class DescrizioneMansioneFragment extends Fragment {
    Button completa;
    private TextView descrizione_tv;
    private String nome;
    private String descrizione;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_descr_mansione, container, false);

        nome=this.getArguments().getString("nome");
        descrizione = this.getArguments().getString("descrizione");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(nome);
        completa = view.findViewById(R.id.complete_button);
        descrizione_tv = view.findViewById(R.id.descrizone_tv);

        descrizione_tv.setText(descrizione) ;

        completa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResocontoMansioneFragment nuovo= new ResocontoMansioneFragment();
                Bundle bundle = new Bundle();
                bundle.putString("nome", nome);
                bundle.putString("descrizione", descrizione);
                nuovo.setArguments(bundle);

                getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();
            }
        });
        return view;
    }
}

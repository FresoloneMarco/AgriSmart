package com.example.agrismart.fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.agrismart.R;

public class SerraContentFragment extends Fragment {
    private Button storico;
    private Button irrigazione;
    private Button areazione;
    private Boolean status_irr;
    private Boolean status_are;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_serra_content, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(this.getArguments().getString("nome"));
        storico=view.findViewById(R.id.button7);
        irrigazione = view.findViewById(R.id.button4);
        areazione = view.findViewById(R.id.button6);
        status_irr = false;
        status_are = false;

        storico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoricoFragment nuovo= new StoricoFragment();

                getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();
            }
        });

        irrigazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status_irr == false){
                    status_irr = true;
                    irrigazione.setBackgroundColor(Color.parseColor("#2E7D32"));
                    irrigazione.setText("FERMA IRRIGAZIONE");
                }else{
                    status_irr = false;
                    irrigazione.setBackgroundColor(Color.parseColor("#81C784"));
                    irrigazione.setText("IRRIGAZIONE");
                }
            }
        });

        areazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (status_are == false){
                    status_are = true;
                    areazione.setBackgroundColor(Color.parseColor("#2E7D32"));
                    areazione.setText("FERMA AREAZIONE");
                }else{
                    status_are = false;
                    areazione.setBackgroundColor(Color.parseColor("#81C784"));
                    areazione.setText("AREAZIONE");
                }
            }
        });
        return view;
    }
}

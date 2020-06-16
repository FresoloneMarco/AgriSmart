package com.example.agrismart.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.agrismart.R;

public class SerraContentFragment extends Fragment {
    private Button storico;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_serra_content, container, false);
        storico=view.findViewById(R.id.button7);
        storico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoricoFragment nuovo= new StoricoFragment();

                getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();
            }
        });
        return view;
    }
}

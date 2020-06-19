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

public class DescrizioneMansioneFragment extends Fragment {
    Button completa;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_descr_mansione, container, false);
        completa = view.findViewById(R.id.complete_button);

        completa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ResocontoMansioneFragment nuovo= new ResocontoMansioneFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();
            }
        });
        return view;
    }
}

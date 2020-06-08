package com.example.agrismart.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.agrismart.R;

public class ProfiloFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profilo, container, false);
        TextView nome= (TextView) view.findViewById(R.id.nomeCristiano);

        String passedParameter=this.getArguments().getString("nome");
        nome.setText(passedParameter);
        return view;
    }
}

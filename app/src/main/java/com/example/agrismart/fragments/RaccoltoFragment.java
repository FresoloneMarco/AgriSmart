package com.example.agrismart.fragments;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.agrismart.R;

public class RaccoltoFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_raccolto, container, false);
        Button b = new Button(view.getContext());
        android.widget.Toolbar.LayoutParams l1 = new android.widget.Toolbar.LayoutParams(android.widget.Toolbar.LayoutParams.WRAP_CONTENT, android.widget.Toolbar.LayoutParams.WRAP_CONTENT);
        l1.gravity = Gravity.END;
        b.setLayoutParams(l1);
        b.setText("right");
        ActionBar toolbar = ((AppCompatActivity) getActivity()).getSupportActionBar();



        return view;
    }
}

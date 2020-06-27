package com.example.agrismart.fragments;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.agrismart.R;

public class ProfiloFragment extends Fragment {

    private ImageView chat;
    private ImageView activities;
    private ImageView inCorso;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profilo, container, false);
        TextView nome= (TextView) view.findViewById(R.id.nomeCristiano);
        activities = view.findViewById(R.id.activities);
        activities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoricoContentFragment nuovo= new StoricoContentFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();
            }
        });

        inCorso = view.findViewById(R.id.inCorso);
        inCorso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InCorsoFragment nuovo = new InCorsoFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();
            }
        });
        LayoutInflater mInflater = LayoutInflater.from(view.getContext());
        View mCustomView = mInflater.inflate(R.layout.chat_button, null);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setCustomView(mCustomView);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(true);
        String passedParameter=this.getArguments().getString("nome");
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(passedParameter);
        nome.setText(passedParameter);

        chat = mCustomView.findViewById(R.id.chat_button);
        chat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChatFragment nuovo= new ChatFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();
            }
        });
        return view;
    }
}

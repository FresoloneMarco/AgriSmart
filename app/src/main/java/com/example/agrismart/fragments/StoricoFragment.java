package com.example.agrismart.fragments;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.agrismart.R;

public class StoricoFragment extends Fragment {
    private ImageView image;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_storico, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(false);
        image = view.findViewById(R.id.imageView11);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StoricoContentFragment nuovo= new StoricoContentFragment();
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();
            }
        });
        return view;
    }
}

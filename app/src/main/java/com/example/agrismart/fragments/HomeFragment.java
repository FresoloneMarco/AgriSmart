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

public class HomeFragment extends Fragment {
    private Button bt1,bt2,bt3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        bt1 = view.findViewById(R.id.bt_read_card1);
        bt2 = view.findViewById(R.id.bt_read_card2);
        bt3 = view.findViewById(R.id.bt_read_card2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readDescr();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readDescr();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readDescr();
            }
        });
        return view;
    }

    public void readDescr(){
        DescrizioneMansioneFragment nuovo= new DescrizioneMansioneFragment();
        getFragmentManager().beginTransaction().replace(R.id.fragment_container, nuovo).commit();
    }




}

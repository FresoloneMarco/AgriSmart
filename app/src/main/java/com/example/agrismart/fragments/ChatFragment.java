package com.example.agrismart.fragments;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.Fragment;


import com.example.agrismart.ChatListAdapter;
import com.example.agrismart.MyListAdapter;
import com.example.agrismart.Products;
import com.example.agrismart.R;

import java.util.ArrayList;


public class ChatFragment extends Fragment {
    private ListView list;
    private ArrayList<String> messaggi;
    private ImageView invia;
    private EditText messaggio;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_chat, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowCustomEnabled(false);

        messaggi = new ArrayList<>();
        invia = view.findViewById(R.id.send_button);
        messaggio = view.findViewById(R.id.editText_messaggio);
        list = view.findViewById(R.id.messaggi);
        final ChatListAdapter adapter = new ChatListAdapter((Activity) view.getContext(), messaggi);
        list = view.findViewById(R.id.messaggi);
        list.setAdapter(adapter);

        invia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messaggi.add(messaggio.getText().toString());
                adapter.notifyDataSetChanged();
            }
        });
        return view;
    }


}

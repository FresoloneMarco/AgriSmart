package com.example.agrismart.fragments;

import android.app.DatePickerDialog;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;


import com.example.agrismart.R;


import java.util.Calendar;

public class MansioniFragment extends Fragment implements DatePickerDialog.OnDateSetListener {
    private Button DataPicker;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mansioni, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Mansioni");
        ListView listView= (ListView) view.findViewById(R.id.scrollView2);
        String[] membri;
        membri = new String[] { "Apicella Giovanni", "Barone Carlo", "Civale Giuseppe", "Rozzi Riccardo", "Rossi Rosario", "Visconti Anna" };
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, membri);
        listView.setAdapter(adapter);
        ListView serreList= (ListView) view.findViewById(R.id.scrollView3);
        String[] serre= new String[]{"Serra 1", "Serra 2", "Serra 3", "Serra 4", "Serra 5"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, serre);
        serreList.setAdapter(adapter2);
        DataPicker = view.findViewById(R.id.button3);


        DataPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adattatore, final View componente, int pos, long id) {

            }
        });

        serreList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adattatore, final View componente, int pos, long id) {

            }
        });

        return view;
    }

    private void showDatePickerDialog(){
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),this, Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            String date= dayOfMonth+"/"+month+"/"+year;
            DataPicker.setText(date);
    }



}

package com.example.agrismart.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.agrismart.Concime;
import com.example.agrismart.ConcimeListAdapter;
import com.example.agrismart.R;
import com.example.agrismart.Seme;
import com.example.agrismart.SemeListAdapter;
import com.example.agrismart.Trattamento;
import com.example.agrismart.TrattamentoListAdapter;

import java.util.ArrayList;

public class MagazzinoFragment extends Fragment {
    private ListView list,list2,list3;
    private ArrayList<Concime> concimi;
    private ArrayList<Trattamento> trattamenti;
    private ArrayList<Seme> semi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_magazzino, container, false);
        concimi = new ArrayList<Concime>();
        trattamenti = new ArrayList<Trattamento>();
        semi = new ArrayList<Seme>();

        Seme s1 = new Seme ("Seme #1", 10, 10);
        semi.add(s1);
        semi.add(s1);
        semi.add(s1);
        semi.add(s1);
        semi.add(s1);
        semi.add(s1);

        Trattamento t1 = new Trattamento("Trattamento #1", 10, 5);
        Trattamento t2 = new Trattamento("Trattamento #2", 10, 2);
        Trattamento t3 = new Trattamento("Trattamento #3", 10, 10);

        trattamenti.add(t1);
        trattamenti.add(t2);
        trattamenti.add(t3);
        trattamenti.add(t3);
        trattamenti.add(t3);
        trattamenti.add(t3);

        Concime c1 = new Concime("Concime #1", 10, 5);
        Concime c2 = new Concime("Concime #2", 20, 20);
        Concime c3 = new Concime("Concime #3", 15, 5);

        concimi.add(c1);
        concimi.add(c2);
        concimi.add(c3);
        concimi.add(c3);
        concimi.add(c3);
        concimi.add(c3);

        final ConcimeListAdapter adapter = new ConcimeListAdapter((Activity) view.getContext(), concimi);
        list = view.findViewById(R.id.concimi_lv);
        list.setAdapter(adapter);

        final TrattamentoListAdapter adapter2 = new TrattamentoListAdapter((Activity) view.getContext(), trattamenti);
        list2 = view.findViewById(R.id.trattamenti_lv);
        list2.setAdapter(adapter2);

        final SemeListAdapter adapter3 = new SemeListAdapter((Activity) view.getContext(), semi);
        list3 = view.findViewById(R.id.semi_lv);
        list3.setAdapter(adapter3);
        return  view;
    }
}

package com.example.androidstudies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.androidstudies.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> lista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding bind = ActivityMainBinding.inflate(LayoutInflater.from(this));
        RecyclerView rc = bind.myList;
        setContentView(bind.getRoot());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(layoutManager);

        lista.add("Repo Name 1");
        lista.add("Repo Name 2");
        lista.add("Repo Name 3");

        ListAdapter listAdpater = new ListAdapter(lista, this);
        rc.setAdapter(listAdpater);




    }
}
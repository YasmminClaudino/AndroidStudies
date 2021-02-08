package com.example.androidstudies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.androidstudies.databinding.ActivityMainBinding;
import com.example.androidstudies.presenter.ListPresenter;

public class MainActivity extends AppCompatActivity implements IListRepository.View {

    private  ListPresenter mPresenter;
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding bind = ActivityMainBinding.inflate(LayoutInflater.from(this));
        RecyclerView rc = bind.myList;
        setContentView(bind.getRoot());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rc.setLayoutManager(layoutManager);

        mPresenter = new ListPresenter();
        mAdapter = new ListAdapter(mPresenter);
        rc.setAdapter(mAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }
}
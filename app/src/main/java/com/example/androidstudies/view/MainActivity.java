package com.example.androidstudies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.androidstudies.databinding.ActivityMainBinding;
import com.example.androidstudies.model.Repository;
import com.example.androidstudies.presenter.ListPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IListRepository.View {

    private final List<Repository> listRepositories = new ArrayList<>();
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

        //Enquanto não pegar o repositórios da API usar para criar no presenter
        mPresenter.createRepository(listRepositories);

    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
        mPresenter.attachView(this);
        mPresenter.onLoad(listRepositories);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
        mPresenter.unattachedView();
    }
}
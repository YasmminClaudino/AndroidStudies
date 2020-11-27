package com.example.androidstudies.view;

import android.view.View;

import com.example.androidstudies.model.Repository;

import java.util.List;

public interface IListRepository {

    interface Presenter{
        void onStart();

        void onStop();

        List<Repository> createRepository(List<Repository> list);

        void onLoad(List<Repository> list);

        void attachView(IListRepository.View view);

        void unattachedView();
    }

    interface View {

    }

}



package com.example.androidstudies.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudies.R;
import com.example.androidstudies.databinding.RvItemRepoBinding;
import com.example.androidstudies.presenter.ListPresenter;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder>{

    private final ListPresenter mPresenter;

    public ListAdapter(ListPresenter presenter) {
        mPresenter = presenter;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {;
        public RvItemRepoBinding rir;
        public MyViewHolder(View v) {
            super(v);
            rir = RvItemRepoBinding.bind(v);
        }
    }

    @NonNull
    @Override
    //Sempre cria uma view nova para os campos de texto que estão no layout selecionado que estão
    //dentro do RecycleView;
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_repo,
                parent,false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d("Yaya", "onBindViewHolder");
        mPresenter.onBindViewHolderListPresenter(holder, position);
    }

    @Override
    public int getItemCount() {
        Log.d("Yaya", "List repositories size: " + mPresenter.getListRepositoriesSize());
       return mPresenter.getListRepositoriesSize();
    }

}
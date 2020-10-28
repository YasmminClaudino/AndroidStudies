package com.example.androidstudies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudies.databinding.RvItemRepoBinding;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder>{

    private final List<String> mLista;
    private Context mContext;

    public  ListAdapter(List<String> lista, Context context) {
        this.mLista = lista;
        this.mContext = context;
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
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
        holder.rir.title.setText(mLista.get(position));
        holder.rir.description.setText("Lorem Ipsum is simply " +
                        "dummy text of the printing.");
        holder.rir.shareNumber.setText("6");
        holder.rir.starNumber.setText("4");

    }

    @Override
    public int getItemCount() {
        if (mLista.size() != 0) {
            return mLista.size();
        } else {
            return 0;
        }
    }
}

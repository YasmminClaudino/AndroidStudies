package com.example.androidstudies.presenter;

import com.example.androidstudies.view.IListRepository;
import com.example.androidstudies.view.ListAdapter;
import com.example.androidstudies.model.Repository;

import java.util.List;

public class ListPresenter implements IListRepository.Presenter {
    private List<Repository> mListRepositories;
    private IListRepository.View mView;

    public ListPresenter(){
    }

    public void onBindViewHolderListPresenter(ListAdapter.MyViewHolder holder, int position){
        holder.rir.title.setText(mListRepositories.get(position).getRepoName());
        holder.rir.description.setText(mListRepositories.get(position).getDescription());
        holder.rir.username.setText(mListRepositories.get(position).getUserName());
        holder.rir.fullname.setText(mListRepositories.get(position).getUserFullName());

    }

    public int getListRepositoriesSize(){
        return mListRepositories.size();
    }

    @Override
    public void onLoad(List<Repository> listRepositories) {
        mListRepositories = listRepositories;
    }

    @Override
    public void attachView(IListRepository.View view) {
        mView = view;

    }

    @Override
    public void unattachedView() {
        mView = null;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    public List<Repository> createRepository(List<Repository> list){
        Repository repository = new Repository();
        repository.setRepoName("AndroidStudies");
        repository.setDescription("This is a project to improve Android knowledge" +
                "such as Manager, Architecture and etc");
        repository.setShareNumber(10);
        repository.setStarNumber(5);
        repository.setUserFullName("Yasmmin Claudino");
        repository.setUserName("yasmminclaudino");
        list.add(repository);
        return list;
    }

}

package com.example.smartcardsnew;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.smartcardsnew.DatabaseFile.FoldersRepository;
import com.example.smartcardsnew.Models.Folders;

import java.util.List;

public class FoldersViewModel extends AndroidViewModel {

    private FoldersRepository mFoldersRepository;
    private LiveData<List<Folders>> mAllFolders;

    public FoldersViewModel(Application application) {
        super(application);
        mFoldersRepository = new FoldersRepository(application);
        mAllFolders = mFoldersRepository.getmAllFolders();
    }
    LiveData<List<Folders>> getmAllFolders(){
        return mAllFolders;
        }

    public void insert(Folders folders) {
        mFoldersRepository.insert(folders);
    }
}

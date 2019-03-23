package com.example.smartcardsnew.DatabaseFile;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.smartcardsnew.AsyncTask.InsertAsyncTask;
import com.example.smartcardsnew.Models.Folders;

import java.util.ArrayList;
import java.util.List;

public class FoldersRepository {

    //private FoldersDataBase mFoldersDataBase;
    private LiveData<List<Folders>> mAllFolders;
    private FoldersDao mFoldersDao;

    public FoldersRepository(Application application){
        FoldersDataBase db = FoldersDataBase.getDatabase(application);
        mFoldersDao = db.foldersDao();
        mAllFolders = mFoldersDao.getAll();
    }

    public LiveData<List<Folders>> getmAllFolders() {
        return mAllFolders;
    }

    public void insert (Folders folders){
        new InsertAsyncTask(mFoldersDao).execute(folders);
    }
}

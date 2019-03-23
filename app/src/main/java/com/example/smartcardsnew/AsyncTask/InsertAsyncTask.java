package com.example.smartcardsnew.AsyncTask;

import android.os.AsyncTask;

import com.example.smartcardsnew.DatabaseFile.FoldersDao;
import com.example.smartcardsnew.Models.Folders;

public class InsertAsyncTask extends AsyncTask<Folders, Void, Void> {

    private FoldersDao mAsyncTaskDao;


    public InsertAsyncTask(FoldersDao dao) {
        mAsyncTaskDao = dao;
    }

    @Override
    protected Void doInBackground(final Folders... folders) {
        mAsyncTaskDao.insertFodlers(folders);
        return null;
    }
}

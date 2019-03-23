package com.example.smartcardsnew.DatabaseFile;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.smartcardsnew.Models.Folders;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface FoldersDao {

    @Insert
    void insertFodlers(Folders... folders);

    @Query("SELECT * FROM folders")
    LiveData <List<Folders>> getAll();

    @Query("SELECT * FROM folders WHERE id = :id")
    Folders getById(long id);


    @Delete
    void  deleteFolders(Folders... folders);

    @Update
    void updateFolders(Folders... folders);

}

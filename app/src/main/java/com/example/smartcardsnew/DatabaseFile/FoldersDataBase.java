package com.example.smartcardsnew.DatabaseFile;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.smartcardsnew.Models.Folders;

@Database(entities = {Folders.class}, version = 2, exportSchema = false)
public abstract class FoldersDataBase extends RoomDatabase {

    public abstract FoldersDao foldersDao();
    //private static final String DATABASE_NAME = "folders_db";
    private static FoldersDataBase INSTANCE;

    static FoldersDataBase getDatabase(final Context context){
        if (INSTANCE == null) {
            synchronized (FoldersDataBase.class){
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), FoldersDataBase.class,
                            "folders_db").fallbackToDestructiveMigration().build();
                }
            }
        }
        return INSTANCE;
    }

//rofl ON GEORGE

    //optimize memory usage(keeps away from having lots of same objects in Database
   // static FoldersDataBase getInstance(final Context context){
     //   if (instance == null){
       //     instance = Room.databaseBuilder(context.getApplicationContext(),FoldersDataBase.class, DATABASE_NAME).build();
      //  }
       // return instance;
  //  }

}

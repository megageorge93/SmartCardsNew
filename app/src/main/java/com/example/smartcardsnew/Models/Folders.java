package com.example.smartcardsnew.Models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "folders")
public class Folders {


    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    @ColumnInfo(name = "Folder Name")
    private String folderName;


public Folders(String folderName){
this.folderName = folderName;

}
    @Ignore
    public Folders() {

    }

    public String getFolderName(){
return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    @Override
    public String toString(){
    return "Folder{"+"id="+id+"name="+folderName+"}";
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}

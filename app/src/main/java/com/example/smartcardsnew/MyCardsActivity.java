package com.example.smartcardsnew;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.smartcardsnew.Adapters.FoldersRecyclerAdapter;
import com.example.smartcardsnew.Models.Folders;

import java.util.ArrayList;

public class MyCardsActivity extends AppCompatActivity {
    private static final String TAG = "NotesListActivity";
   private RecyclerView mRecyclerView;

   private ArrayList<Folders> mFolders = new ArrayList<>();
   private FoldersRecyclerAdapter mFoldersRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cards);
        mRecyclerView = findViewById(R.id.folder_RecyclerView);

        initRecyclerView();
        insertFolders();
    }

    private void insertFolders(){
        for(int i = 0; i<100; i++){
        Folders folder = new Folders();
        folder.setFolderName("title" + i);

        mFolders.add(folder);}
        mFoldersRecyclerAdapter.notifyDataSetChanged();
    }
private void initRecyclerView(){
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    mRecyclerView.setLayoutManager(linearLayoutManager);
    //mRecyclerView = (RecyclerView) findViewById(R.id.folder_RecyclerView);
    mFoldersRecyclerAdapter = new FoldersRecyclerAdapter(mFolders);
    mRecyclerView.setAdapter(mFoldersRecyclerAdapter);
}
}

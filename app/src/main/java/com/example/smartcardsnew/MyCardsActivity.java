package com.example.smartcardsnew;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.smartcardsnew.Adapters.FoldersRecyclerAdapter;
import com.example.smartcardsnew.Models.Folders;

import java.util.ArrayList;

public class MyCardsActivity extends AppCompatActivity {
    private static final String TAG = "NotesListActivity";
   private RecyclerView mRecyclerView;

   private ArrayList<Folders> mFolders = new ArrayList<>();
   private FoldersRecyclerAdapter mFoldersRecyclerAdapter;
   private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cards);
        mRecyclerView = findViewById(R.id.folder_RecyclerView);

        //adding new Folder
        addButton = findViewById(R.id.fab);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFolder();
            }
        });

        initRecyclerView();

    }


    private void addFolder(){
        Folders newFolder = new Folders();
        newFolder.setFolderName("New Folder");
        mFolders.add(newFolder);
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

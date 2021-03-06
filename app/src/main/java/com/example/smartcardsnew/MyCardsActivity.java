package com.example.smartcardsnew;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Button;

import com.example.smartcardsnew.Adapters.FoldersRecyclerAdapter;
import com.example.smartcardsnew.Helper.RecyclerItemTouchHelper;
import com.example.smartcardsnew.Helper.RecyclerItemTouchHelperListener;
import com.example.smartcardsnew.Models.Folders;

import java.util.ArrayList;

public class MyCardsActivity extends AppCompatActivity implements RecyclerItemTouchHelperListener {
   //Need to Add functionality of Edit Mode and View Mode. When add Buton is pressed or on long click - Edit Mode
   private RecyclerView mRecyclerView;

   private ArrayList<Folders> mFolders = new ArrayList<>();
   private FoldersRecyclerAdapter mFoldersRecyclerAdapter;
   private FloatingActionButton addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cards);

        mRecyclerView = findViewById(R.id.folder_RecyclerView);
        ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new RecyclerItemTouchHelper(0,ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(mRecyclerView);
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


    public void addFolder(){
        Folders newFolder = new Folders();
        newFolder.setFolderName("New Folder");
        mFolders.add(newFolder);
        //scrolls to the last item after adding
        mRecyclerView.smoothScrollToPosition(mFolders.size());
        mFoldersRecyclerAdapter.notifyDataSetChanged();
    }

    public void deleteFolder(int position){
        mFolders.remove(position);
        mFoldersRecyclerAdapter.notifyDataSetChanged();
    }
private void initRecyclerView(){
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    mRecyclerView.setLayoutManager(linearLayoutManager);
    //mRecyclerView = (RecyclerView) findViewById(R.id.folder_RecyclerView);
    mFoldersRecyclerAdapter = new FoldersRecyclerAdapter(mFolders);
    mRecyclerView.setAdapter(mFoldersRecyclerAdapter);
    mFoldersRecyclerAdapter.setOnItemClickListener(new FoldersRecyclerAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(int position) {
            mFolders.get(position);
            Intent folderListIntent = new Intent(MyCardsActivity.this, CardListActivity.class);
            startActivity(folderListIntent);
            mFoldersRecyclerAdapter.notifyDataSetChanged();
        }
    });
}

    @Override
    public void onSwiper(RecyclerView.ViewHolder viewHolder, int direction, int position) {
    if (viewHolder instanceof FoldersRecyclerAdapter.ViewHolder){
        String name = mFolders.get(viewHolder.getAdapterPosition()).getFolderName();
        Folders deletedFolder = mFolders.get(viewHolder.getAdapterPosition());
        int deleteIndex = viewHolder.getAdapterPosition();
        deleteFolder(deleteIndex);
    }
    }
}

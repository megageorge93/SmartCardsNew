package com.example.smartcardsnew.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.smartcardsnew.Models.Folders;
import com.example.smartcardsnew.R;


import java.util.ArrayList;


public class FoldersRecyclerAdapter extends RecyclerView.Adapter<FoldersRecyclerAdapter.ViewHolder> {
   private ArrayList<Folders> mFolders = new ArrayList<>();



    public FoldersRecyclerAdapter(ArrayList<Folders> mFolders) {
        this.mFolders = mFolders;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.folders_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.folderName.setText(mFolders.get(i).getFolderName());
    }

    @Override
    public int getItemCount() {
        return mFolders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView folderName;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        folderName = itemView.findViewById(R.id.folderTextView);
    }
}

}
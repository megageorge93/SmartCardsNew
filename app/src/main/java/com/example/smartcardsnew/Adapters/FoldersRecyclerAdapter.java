package com.example.smartcardsnew.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.smartcardsnew.Models.Folders;
import com.example.smartcardsnew.R;


import java.util.ArrayList;


public class FoldersRecyclerAdapter extends RecyclerView.Adapter<FoldersRecyclerAdapter.ViewHolder> {
   private ArrayList<Folders> mFolders = new ArrayList<>();
   private OnItemClickListener mListener;

   public interface OnItemClickListener{
       void onItemClick(int position);
   }

   public void setOnItemClickListener (OnItemClickListener listener){
       mListener = listener;
   }

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
        public RelativeLayout viewBackground, viewForeground;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        folderName = itemView.findViewById(R.id.folderTextView);
        viewBackground = itemView.findViewById(R.id.view_background);
        viewForeground = itemView.findViewById(R.id.text_container);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        mListener.onItemClick(position);
                    }
                }
            }
        });
    }
}



}
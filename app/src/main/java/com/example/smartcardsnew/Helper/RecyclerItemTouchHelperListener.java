package com.example.smartcardsnew.Helper;

import android.support.v7.widget.RecyclerView;

public interface RecyclerItemTouchHelperListener {
    void onSwiper(RecyclerView.ViewHolder viewHolder, int direction, int position);
}

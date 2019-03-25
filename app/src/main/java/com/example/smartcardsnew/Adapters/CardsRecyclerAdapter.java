package com.example.smartcardsnew.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.smartcardsnew.Models.Cards;
import com.example.smartcardsnew.R;

import java.util.ArrayList;

public class CardsRecyclerAdapter extends RecyclerView.Adapter<CardsRecyclerAdapter.CardViewHolder> {
    private ArrayList<Cards> mCards = new ArrayList<>();
    private OnItemClickListener mCardListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener (OnItemClickListener listener){
        mCardListener = listener;
    }

    public CardsRecyclerAdapter(ArrayList<Cards> mCards) {
        this.mCards = mCards;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cards_list_item, viewGroup, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
        cardViewHolder.cardName.setText(mCards.get(i).getCardName());
    }

    @Override
    public int getItemCount() {
        return mCards.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder{
        TextView cardName;
        public RelativeLayout cardForeground, cardBackground;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            cardName = itemView.findViewById(R.id.card_TextView);
            cardForeground = itemView.findViewById(R.id.card_foreground);
            cardBackground = itemView.findViewById(R.id.card_background);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mCardListener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mCardListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}

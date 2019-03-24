package com.example.smartcardsnew;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.smartcardsnew.Adapters.CardsRecyclerAdapter;
import com.example.smartcardsnew.Helper.RecyclerItemTouchHelper;
import com.example.smartcardsnew.Helper.RecyclerItemTouchHelperListener;
import com.example.smartcardsnew.Models.Cards;
import com.example.smartcardsnew.Models.Folders;

import java.util.ArrayList;

public class CardListActivity extends AppCompatActivity implements RecyclerItemTouchHelperListener {
//Need to Add Functionality Edit Mode and View Mode
    public RecyclerView cardRecyclerView;
    public ArrayList<Cards> mCards = new ArrayList<Cards>();
    public CardsRecyclerAdapter cardAdapter;


    private FloatingActionButton addCardButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        cardRecyclerView = findViewById(R.id.card_RecyclerView);
        ItemTouchHelper.SimpleCallback itemTouchHelperCallBack = new RecyclerItemTouchHelper(0,ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(cardRecyclerView);
        //adding new Folder
        addCardButton = findViewById(R.id.cards_fab);
        addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenEditCard();
            }
        });

        initRecyclerView();
    }



    public void OpenEditCard() {
        Intent editCardIntent = new Intent(CardListActivity.this, EditCardActivity.class);
        startActivity(editCardIntent);
    }
    //add card name from edit text of EditCard Activity
    public void addCard(){
        Cards newCard = new Cards();
        newCard.setCardName("New Card");
        mCards.add(newCard);
        //scrolls to the last item after adding
        cardRecyclerView.smoothScrollToPosition(mCards.size());
        cardAdapter.notifyDataSetChanged();
    }

    public void deleteCard(int position){
        mCards.remove(position);
        cardAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        LinearLayoutManager cardlinearLayoutManager = new LinearLayoutManager(this);
        cardRecyclerView.setLayoutManager(cardlinearLayoutManager);
        cardAdapter = new CardsRecyclerAdapter(mCards);
        cardRecyclerView.setAdapter(cardAdapter);
        cardAdapter.setOnItemClickListener(new CardsRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                mCards.get(position);
                Intent cardListIntent = new Intent(CardListActivity.this, EditCardActivity.class);
                startActivity(cardListIntent);
                cardAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onSwiper(RecyclerView.ViewHolder viewHolder, int direction, int position) {
        if (viewHolder instanceof CardsRecyclerAdapter.CardViewHolder){
            String name = mCards.get(viewHolder.getAdapterPosition()).getCardName();
            Cards deletedCards = mCards.get(viewHolder.getAdapterPosition());
            int deleteIndex = viewHolder.getAdapterPosition();
            deleteCard(deleteIndex);
        }
    }
}

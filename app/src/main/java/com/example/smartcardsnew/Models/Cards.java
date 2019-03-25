package com.example.smartcardsnew.Models;

public class Cards {

    private long cardId;

    private String cardName;

    public Cards(String cardName) {
        this.cardName = cardName;
    }

    public Cards() {

    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public String toString() {
        return "Cards{" +
                "cardId=" + cardId +
                ", cardName='" + cardName + '\'' +
                '}';
    }

    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }
}

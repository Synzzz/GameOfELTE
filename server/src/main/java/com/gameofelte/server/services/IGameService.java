package com.gameofelte.server.services;

import com.gameofelte.game.Field;
import com.gameofelte.game.LuckyCard;
import java.util.List;

public interface IGameService 
{
    boolean isOver();
    int getActivePlayerIndex();
    void start();
    void nextPlayer();
    void setPlayerField(int fieldIndex);
    void pickLuckyCard(int cardIndex) throws Exception;
    void useLuckyCard(int cardIndex) throws Exception;
    List<LuckyCard> getLuckyCards();
    List<Field> getFields();
    
    void setMoney(int playerIndex, int money);
}

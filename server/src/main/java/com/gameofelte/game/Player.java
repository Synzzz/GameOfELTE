package com.gameofelte.game;

import com.gameofelte.server.services.IGameService;
import java.util.ArrayList;
import java.util.List;

public class Player 
{
    private int fieldIndex = 0;
    private int money;
    private final List<LuckyCard> luckyCards = new ArrayList<>();
    private final List<Subject> completedSubjects = new ArrayList<>();
    private final List<Subject> registeredSubjects = new ArrayList<>();
    private final int playerIndex;
    private final IGameService game;
    
    public Player(int playerIndex, IGameService game)
    {
        this.playerIndex = playerIndex;
        this.game = game;
    }
    
    public int getFieldIndex()
    {
        return fieldIndex;
    }
    
    public void setFieldIndex(int index)
    {
        fieldIndex = index;
    }
    
    public void addLuckyCard(LuckyCard card)
    {
        luckyCards.add(card);
    }
    
    public boolean removeLuckyCard(LuckyCard card)
    {
        return luckyCards.remove(card);
    }
    
    public void earnMoney(int amount)
    {
        money += amount;
        
        game.setMoney(playerIndex, money);
    }
    
    public void payMoney(int amount)
    {
        money -= amount;
        
        game.setMoney(playerIndex, money);
    }
    
    // TODO
    public void registerSubject(Subject subject)
    {
        
    }

    // TODO
    public void completeSubject(Subject subject)
    {
        
    }

    public List<Subject> getRegisteredSubjects() 
    {
        return registeredSubjects;
    }
}

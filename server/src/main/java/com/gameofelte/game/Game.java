package com.gameofelte.game;

import com.gameofelte.server.services.IGameService;
import java.util.ArrayList;
import java.util.List;
import com.gameofelte.server.services.IClientManagerService;

public class Game implements IGameService
{
    private int activePlayerIndex = 0;
    private boolean gameOver = false;
    private boolean firstRound = true;
    private int semester = 1;
    private final List<Player> players = new ArrayList<>();
    private final List<Field> fields = new ArrayList<>();
    private final IClientManagerService clientManager;
    private final List<LuckyCard> luckyCards = new ArrayList<>();
    
    public Game(IClientManagerService clientManager, int playerCount)
    {
        this.clientManager = clientManager;
        
        for(int i = 0; i < playerCount; i++)
            players.add(new Player(i, this));
    }
    // TODO
    private List<Integer> generateRandomNumbers()
    {
        return null;
    }
    
    @Override
    public boolean isOver()
    {
        return gameOver;
    }
    
    @Override
    public void start()
    {
        clientManager.activatePlayer(0);
    }
    
    @Override
    public void nextPlayer()
    {
        if(players.get(0).getFieldIndex() == fields.size() - 1)
        {
            semester++;
            clientManager.sendRandomNumbersToAll(generateRandomNumbers());
        }
        
        activePlayerIndex = (activePlayerIndex + 1) % players.size();
        
        if(activePlayerIndex == 0)
            firstRound = false;
        
        if(firstRound)
            clientManager.showSubjectRegistrationWindow(activePlayerIndex);
        
        clientManager.activatePlayer(activePlayerIndex);
    }

    @Override
    public int getActivePlayerIndex() 
    {
        return activePlayerIndex;
    }

    @Override
    public void setPlayerField(int fieldIndex) 
    {
        Player activePlayer = players.get(activePlayerIndex);
        activePlayer.setFieldIndex(fieldIndex);
        fields.get(fieldIndex).effectPlayer(activePlayer);
    }

    @Override
    public void pickLuckyCard(int cardIndex) throws Exception 
    {
        LuckyCard card = luckyCards.get(cardIndex);
        Player activePlayer = players.get(activePlayerIndex);
        
        if(card.isCollectible())
            activePlayer.addLuckyCard(card);
        else
            card.effectPlayer(activePlayer);
    }

    @Override
    public void useLuckyCard(int cardIndex) throws Exception 
    {
        LuckyCard card = luckyCards.get(cardIndex);
        Player activePlayer = players.get(activePlayerIndex);
         
        if(!activePlayer.removeLuckyCard(card))
            throw new Exception("Nincs ilyen kártyád");
        
        card.effectPlayer(activePlayer);
    }

    @Override
    public List<LuckyCard> getLuckyCards() 
    {
        return luckyCards;
    }

    @Override
    public List<Field> getFields() 
    {
        return fields;
    }

    @Override
    public void setMoney(int playerIndex, int money) 
    {
        clientManager.setMoney(playerIndex, money);
    }
}

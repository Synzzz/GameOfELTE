package com.gameofelte.game;

import com.gameofelte.server.services.IGameService;
import java.util.ArrayList;
import java.util.List;
import com.gameofelte.server.services.IClientManagerService;
import java.util.Random;

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
 
    private List<Integer> generateRandomNumbers()
    {
        int sum = 0;
	Random random = new Random();
	List<Integer> values = new ArrayList<>();
		
        while(sum < fields.size()){
            int value = sum >= fields.size()-6 ? fields.size() - sum : random.nextInt(6) + 1;
            sum+=value;
            values.add(value);
        }

        return values;
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
        clientManager.showSubjectRegistrationWindow(activePlayerIndex);
    }
    
    @Override
    public void nextPlayer()
    {
        activePlayerIndex = (activePlayerIndex + 1) % players.size();
        
        if(players.get(0).getFieldIndex() == 0)//ha az első játékos következik, és az első mezőn áll => körbeértek a játékosok, új szemeszter
        {
            semester++;
            clientManager.sendRandomNumbersToAll(generateRandomNumbers());
        }
        
        if(activePlayerIndex == 0)
            firstRound = false;
        
        if(firstRound)//az első körben mindenki a tárgyfelvétellel kezd
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

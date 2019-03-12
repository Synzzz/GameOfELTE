package com.gameofelte.game;

import com.gameofelte.services.IGameService;
import java.util.ArrayList;
import java.util.List;

public class Player 
{
    private int fieldIndex = 0;
    private int money;
    private final List<LuckyCard> luckyCards = new ArrayList<>();
    private final List<Subject> completedSubjects = new ArrayList<>();
    private final List<Subject> registeredSubjects = new ArrayList<>();
    private final List<Subject> learnedSubjects = new ArrayList<>();
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
    
    // TODO
    public void beginUnregisterSubject(){
        
    }
    
    // TODO
    public void beginCourseRequest(){
        
        
    }
    
    public List<Subject> getLearnedSubjects() 
    {
        return learnedSubjects;
    }
    
    public void learnSubject(Subject subject)
    {
        learnedSubjects.add(subject);
    }
    
    public void removeSubjectByIndex(int num){
        registeredSubjects.remove(num);
    }
    
    // TODO
    public void pickingLuckyCard() throws Exception
    {
        
    }
    
    // TODO
    public void beginLearnSubject()
    {
        
    }
    // TODO
    public void beginChoiceWorkStudy(){
        
    
    }
}

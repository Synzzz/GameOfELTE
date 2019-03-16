package com.gameofelte.game;

import com.gameofelte.services.IGameService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player 
{
    private int fieldIndex = 0;
    private int money;
    private boolean stateFund;
    private final ArrayList<LuckyCard> luckyCards = new ArrayList<>();
    private final ArrayList<Subject> completedSubjects = new ArrayList<>();
    private final ArrayList<Subject> registeredSubjects = new ArrayList<>();
    private final ArrayList<Subject> learnedSubjects = new ArrayList<>();
    private final int playerIndex;
    private final IGameService game;
    
    public Player(int playerIndex, IGameService game)
    {
        this.playerIndex = playerIndex;
        this.game = game;
        this.stateFund = true;
    }
    
    public int getFieldIndex()
    {
        return fieldIndex;
    }
    
    public void setFieldIndex(int index)
    {
        fieldIndex = index;
    }
    
    public List<Subject> getRegisteredSubjects() 
    {
        return registeredSubjects;
    }
    
    public List<Subject> getLearnedSubjects() 
    {
        return learnedSubjects;
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
    
    public ArrayList<String> subjectListToStringList(ArrayList<Subject> subjects)
    {
        ArrayList<String> strings=new ArrayList<>();
        for(Subject s :subjects)
        {
            strings.add(s.getName());
        }
        return strings;
    }
    
    public void registerSubject(Subject subject) throws Exception
    {
        if(completedSubjects.contains(subject) || !subjectListToStringList(completedSubjects).containsAll(subject.getPrerequisites()))
        {
            throw new Exception("Ezt a tárgyat nem veheted fel");
        }
        else
        {
            registeredSubjects.add(subject);
        }
    }

    //csak az Exam-ban hivjuk, learned-eken megy végig ott alapból
    public void completeSubject(Subject subject)
    {
        /*
        if(!learnedSubjects.contains(subject))
        {
            throw new Exception("Ezt a tárgyat még nem tanultad meg");
        }
        */
        completedSubjects.add(subject);
        learnedSubjects.remove(subject);
        registeredSubjects.remove(subject);
}

    public void beginUnregisterSubject() throws Exception
    {
        if(registeredSubjects.isEmpty())
        {
            throw new Exception("Nincs leadható tárgyad");
        }
    }
   
    public void learnSubject(Subject subject)
    {
        learnedSubjects.add(subject);
    }
    
    // exception
    public void removeSubjectByIndex(int num)
    {
        registeredSubjects.remove(num);
    }
    
    public void removeRandomSubject(){
       Random rand = new Random();
       int max = getRegisteredSubjects().size();
       int num = rand.nextInt(max);
       removeSubjectByIndex(num);
    }
    
    // TODO
    public void pickingLuckyCard() throws Exception
    {
        
    }
    
    public void beginLearnSubject() throws Exception
    {
        if(learnedSubjects.containsAll(registeredSubjects))
        {
            throw new Exception("Már minden felvett tárgyat megtanultál");
        }
    }
    
    // TODO
    public void beginWorkOrStudyChoice()
    {
        
    }
     
    // TODO OR NOT TODO
    public void beginCourseRequest()throws Exception
    {
        
    }
    
    public void changeStateFundStatus(boolean b){
        this.stateFund = b;
    }
    
    // TODO
    public void beginLosingKnowledge(){
        
    }
    
    // TODO
    public void beginCompleteSubject(){
        
    }
    
    // TODO - mateking szerencsekártya
    public void beginMatekingChoice(){
        
    }
    
    // TODO - túlóra szerencsekártya
    public void beginOvertimeWork(){
        
    }
    
}

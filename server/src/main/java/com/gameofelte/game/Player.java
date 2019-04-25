package com.gameofelte.game;

import com.gameofelte.services.IGameService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class for the player
 */
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
    
    /**
     * Constructor for the player
     * @param playerIndex index of the player
     * @param game the game
     */
    public Player(int playerIndex, IGameService game)
    {
        this.playerIndex = playerIndex;
        this.game = game;
        this.stateFund = true;
    }
    
    /**
     * @return field index
     */
    public int getFieldIndex()
    {
        return fieldIndex;
    }
    
    /**
     * Sets player's field index to the parameter
     * @param index field index to move to
     */
    public void setFieldIndex(int index)
    {
        fieldIndex = index;
    }
    
    /**
     * @return list of registered subjects
     */
    public List<Subject> getRegisteredSubjects() 
    {
        return registeredSubjects;
    }
    
    /**
     * @return list of learned subjects
     */
    public List<Subject> getLearnedSubjects() 
    {
        return learnedSubjects;
    }
    
    /**
     * Adds the card to the player
     * @param card card to give
     */
    public void addLuckyCard(LuckyCard card)
    {
        luckyCards.add(card);
    }
    
    /**
     * Removes the lucky card from the player
     * @param card card to remove
     * @return if the remove was successful
     */
    public boolean removeLuckyCard(LuckyCard card)
    {
        return luckyCards.remove(card);
    }
    
    /**
     * Gives the player the money in parameter
     * @param amount amount of money to give
     */
    public void earnMoney(int amount)
    {
        money += amount;
        game.setMoney(playerIndex, money);
    }
    
    /**
     * Removes the amount of money from the player
     * @param amount amount of money to remove
     */
    public void payMoney(int amount)
    {
        money -= amount;
        game.setMoney(playerIndex, money);
    }
    
    /**
     * Converts a list of Subjects to a list of Strings
     * @param subjects list of Subjects
     * @return list of Strings
     */
    public ArrayList<String> subjectListToStringList(ArrayList<Subject> subjects)
    {
        ArrayList<String> strings=new ArrayList<>();
        for(Subject s :subjects)
        {
            strings.add(s.getName());
        }
        return strings;
    }
    
    /**
     * Adds the parameter subject to the registered subjects
     * @param subject subject to register
     * @throws Exception if the subject is already registered or completed
     */
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

    /**
     * Adds the parameter subject to the completed subjects
     * @param subject subject to complete
     */
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

    
   
    /**
     * Adds the parameter subject to the learned subjects
     * @param subject subject to learn
    */
    public void learnSubject(Subject subject)
    {
        learnedSubjects.add(subject);
    }
    
    // exception

    /**
     * Removes the subject at a given index from registered list
     * @param num index to remove
     */
    public void removeSubjectByIndex(int num)
    {
        registeredSubjects.remove(num);
    }
    
    /**
     * Removes a random subject from registered list
     */
    public void removeRandomSubject(){
       Random rand = new Random();
       int max = getRegisteredSubjects().size();
       int num = rand.nextInt(max);
       removeSubjectByIndex(num);
    }
    
    // TODO

    /**
     * TODO
     * @throws Exception TODO
     */
    public void pickingLuckyCard() throws Exception
    {
        
    }
    
    
    //TODO

    /**
     * Sends the learn subject message to the client
     * @throws Exception if there's no subject to learn
     */
    public void beginLearnSubject() throws Exception
    {
        
        if(learnedSubjects.containsAll(registeredSubjects))
        {
            throw new Exception("Már minden felvett tárgyat megtanultál");
        }
        else
        {
            game.beginLearnSubject(playerIndex);
        }
    }
    
    /**
     * Sends the unregister subject message to the client
     * @throws Exception if there's no registered subject
     */
    public void beginUnregisterSubject() throws Exception
    {
        // TODO
        if(registeredSubjects.isEmpty())
        {
            throw new Exception("Nincs leadható tárgyad");
        }
        else
        {
            game.beginUnregisterSubject(playerIndex);
        }
    }
    
    // TODO

    /**
     * Sends the work or study message to the client
     */
    public void beginWorkOrStudyChoice()
    {
        game.beginWorkOrStudyChoice(playerIndex);
    }
     
    // TODO OR NOT TODO

    /**
     * Sends the work or study message to the client
     * @throws Exception if the player cannot get a request
     */
    public void beginCourseRequest()throws Exception
    {
        game.beginCourseRequest(playerIndex);
    }
    
    /**
     * Changes state fund to the parameter
     * @param b value to change the state fund to
     */
    public void changeStateFundStatus(boolean b){
        this.stateFund = b;
    }
    
    // TODO

    /**
     * Sends the losing knowledge message to the client
     */
    public void beginLosingKnowledge(){
        game.beginLosingKnowledge(playerIndex);
    }
    
    // TODO

    /**
     * Sends the offered mark message to the client
     */
    public void beginOfferedMark(){
        game.beginOfferedMark(playerIndex);
    }
    
    // TODO - mateking szerencsekártya

    /**
     * Sends the mateking choice message to the client
     */
    public void beginMatekingChoice(){
        game.beginMatekingChoice(playerIndex);
    }
    
    // TODO - túlóra szerencsekártya

    /**
     * Sends the overtime work message to the client
     */
    public void beginOvertimeWork(){
        game.beginOvertimeWork(playerIndex);
    }
    
}

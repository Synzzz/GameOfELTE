package com.gameofelte.game;

import com.gameofelte.services.IGameService;
import com.gameofelte.services.IClientManagerService;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class for managing the Game
 */
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
    
    /**
     * Constructor for the game
     * @param clientManager the GameServer
     * @param playerCount how many players to start
     * @param fields list of the fields in String format, divided by "|"
     * @param cards list of the cards in String format, divided by "|"
     */
    public Game(IClientManagerService clientManager, int playerCount,String fields,String cards)
    {
        this.clientManager = clientManager;
        for(int i = 0; i < playerCount; i++)
            players.add(new Player(i, this));
        for (String type : fields.split("|"))
        {
            this.fields.add(FieldFactory.makeField(type));
        }
        for (String type : cards.split("|"))
        {
            this.luckyCards.add(LuckyCardFactory.makeLuckyCard(type));
        }
    }
 
    /**
     * Generates a list of random Integers so the sum of each list is the same
     * @return list of Integers
     */
    public List<Integer> generateRandomNumbers()
    {
        int sum = 0;
	Random random = new Random();
	List<Integer> values = new ArrayList<>();
		
        while(sum < fields.size()){
            int value = (sum >= fields.size()-6 ? (fields.size() - sum) : (random.nextInt(6) + 1));
            sum+=value;
            values.add(value);
        }

        return values;
    }
    
    /**
     * @return boolean telling if the game is over
     */
    @Override
    public boolean isOver()
    {
        return gameOver;
    }
    
    /**
     * Starts the game with sending the first popup window command to the first player
     */
    @Override
    public void start()
    {
        clientManager.activatePlayer(0);
        clientManager.showSubjectRegistrationWindow(activePlayerIndex);
    }
    
    /**
     * Switches to the next player.
     */
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

    /**
     * @return index of the current player
     */
    @Override
    public int getActivePlayerIndex() 
    {
        return activePlayerIndex;
    }

    /**
     * Changes the current player's field to the one in fieldIndex
     * @param fieldIndex index of the field
     * @throws Exception if the field effect couldn't be used
     */
    @Override
    public void setPlayerField(int fieldIndex) throws Exception 
    {
        Player activePlayer = players.get(activePlayerIndex);
        activePlayer.setFieldIndex(fieldIndex);
        fields.get(fieldIndex).effectPlayer(activePlayer);
    }

    /**
     * Takes a card at the cardIndex from the lucky card pile and activates it if it isn't a collectible
     * @param cardIndex index of the card
     * @throws Exception if the effect couldn't be used
     */
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

    /**
     * Activates a card at the cardIndex if the player has it
     * @param cardIndex index of the card
     * @throws Exception if the player doesn't have the card
     */
    @Override
    public void useLuckyCard(int cardIndex) throws Exception 
    {
        LuckyCard card = luckyCards.get(cardIndex);
        Player activePlayer = players.get(activePlayerIndex);
         
        if(!activePlayer.removeLuckyCard(card))
            throw new Exception("Nincs ilyen kártyád");
        
        card.effectPlayer(activePlayer);
    }

    /**
     * @return lucky cards list
     */
    @Override
    public List<LuckyCard> getLuckyCards() 
    {
        return luckyCards;
    }

    /**
     * @return fields
     */
    @Override
    public List<Field> getFields() 
    {
        return fields;
    }

    /**
     * sets the player at playerIndex's money to the amount given
     * @param playerIndex index of the player
     * @param money amount of money 
     */
    @Override
    public void setMoney(int playerIndex, int money) 
    {
        clientManager.setMoney(playerIndex, money);
    }
    
    /**
     * Sends the learn subject command to the client through the server
     * @param playerIndex index of the player
     */
    @Override
    public void beginLearnSubject(int playerIndex) {
        clientManager.beginLearnSubject(playerIndex);
    }

    /**
     * Sends the work or study command to the client through the server
     * @param playerIndex index of the player
     */
    @Override
    public void beginWorkOrStudyChoice(int playerIndex) {
        clientManager.beginWorkOrStudyChoice(playerIndex);
    }

    /**
     * Sends the course request command to the client through the server
     * @param playerIndex index of the player
     */
    @Override
    public void beginCourseRequest(int playerIndex) {
        clientManager.beginCourseRequest(playerIndex);
    }

    /**
     * Sends the lose knowledge command to the client through the server
     * @param playerIndex index of the player
     */
    @Override
    public void beginLosingKnowledge(int playerIndex) {
        clientManager.beginLosingKnowledge(playerIndex);
    }

    /**
     * Sends the offered mark command to the client through the server
     * @param playerIndex index of the player
     */
    @Override
    public void beginOfferedMark(int playerIndex) {
        clientManager.beginOfferedMark(playerIndex);
    }

    /**
     * Sends the mateking choice command to the client through the server
     * @param playerIndex index of the player
     */
    @Override
    public void beginMatekingChoice(int playerIndex) {
        clientManager.beginMatekingChoice(playerIndex);
    }

    /**
     * Sends the overtime work command to the client through the server
     * @param playerIndex index of the player
     */
    @Override
    public void beginOvertimeWork(int playerIndex) {
        clientManager.beginOvertimeWork(playerIndex);
    }

    /**
     * Sends the unregister subject command to the client through the server
     * @param playerIndex index of the player
     */
    @Override
    public void beginUnregisterSubject(int playerIndex) {
        clientManager.beginUnregisterSubject(playerIndex);
    }
}

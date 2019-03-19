package com.gameofelte.services;

import com.gameofelte.game.Field;
import com.gameofelte.game.LuckyCard;
import java.util.List;

public interface IGameService 
{
    boolean isOver();
    int getActivePlayerIndex();
    void start();
    void nextPlayer();
    void setPlayerField(int fieldIndex) throws Exception;
    void pickLuckyCard(int cardIndex) throws Exception;
    void useLuckyCard(int cardIndex) throws Exception;
    List<LuckyCard> getLuckyCards();
    List<Field> getFields();
    void beginLearnSubject(int playerIndex);
    void beginWorkOrStudyChoice(int playerIndex);
    void beginCourseRequest(int playerIndex);
    void beginLosingKnowledge(int playerIndex);
    void beginOfferedMark(int playerIndex);
    void beginMatekingChoice(int playerIndex);
    void beginOvertimeWork(int playerIndex);
    void beginUnregisterSubject(int playerIndex);
    void setMoney(int playerIndex, int money);
}

package com.gameofelte.services;

import java.util.List;

public interface IClientManagerService 
{
    void sendRandomNumbersToAll(List<Integer> numbers);
    void activatePlayer(int playerIndex);
    void showSubjectRegistrationWindow(int playerIndex);
    void sendGameOver(List<Integer> scoreboard);
    void setMoney(int playerIndex, int money);
    void beginLearnSubject(int playerIndex);
    void beginWorkOrStudyChoice(int playerIndex);
    void beginCourseRequest(int playerIndex);
    void beginLosingKnowledge(int playerIndex);
    void beginOfferedMark(int playerIndex);
    void beginMatekingChoice(int playerIndex);
    void beginOvertimeWork(int playerIndex);
    void beginUnregisterSubject(int playerIndex);
}

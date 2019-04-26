package com.gameofelte.services;

import java.util.List;

public interface IClientManagerService 
{
    void sendRandomNumbersToAll(List<Integer> numbers);
    void activatePlayer(int playerIndex);
    void showSubjectRegistrationWindow(int playerIndex);
    void sendGameOver(List<Integer> scoreboard);
    void setMoney(int playerIndex, int money);
    void cBeginLearnSubject(int playerIndex);
    void cBeginWorkOrStudyChoice(int playerIndex);
    void cBeginCourseRequest(int playerIndex);
    void cBeginLosingKnowledge(int playerIndex);
    void cBeginOfferedMark(int playerIndex);
    void cBeginMatekingChoice(int playerIndex);
    void cBeginOvertimeWork(int playerIndex);
    void cBeginUnregisterSubject(int playerIndex);
}

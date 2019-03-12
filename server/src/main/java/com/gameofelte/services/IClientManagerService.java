package com.gameofelte.services;

import java.util.List;

public interface IClientManagerService 
{
    void sendRandomNumbersToAll(List<Integer> numbers);
    void activatePlayer(int playerIndex);
    void showSubjectRegistrationWindow(int playerIndex);
    void sendGameOver(List<Integer> scoreboard);
    void setMoney(int playerIndex, int money);
}

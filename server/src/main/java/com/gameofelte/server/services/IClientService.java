package com.gameofelte.server.services;

import com.gameofelte.game.Field;
import com.gameofelte.game.LuckyCard;
import java.net.Socket;
import java.util.List;

public interface IClientService 
{
    void sendColor(int color);
    void sendRandomNumbers(List<Integer> numbers);
    void sendLuckyCards(List<LuckyCard> luckyCards);
    void sendBoard(List<Field> fields);
    void sendGameOver(List<Integer> scoreboard);
    void setMoney(int amount);
    Socket getSocket();
    void showSubjectRegistrationWindow();
    void activate();
    void close();
}

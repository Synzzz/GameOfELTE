package com.gameofelte.services;

import com.gameofelte.game.Field;
import com.gameofelte.game.LuckyCard;
import com.gameofelte.server.Message;
import com.gameofelte.server.Response;
import java.net.Socket;
import java.util.List;

public interface IClientService 
{
     void sendColor(int color);
    void sendRandomNumbers(List<Integer> numbers);
    void sendMessage(Message msg);
    void sendResponse(Response response);
    void sendLuckyCards(List<LuckyCard> luckyCards);
    void sendBoard(List<Field> fields);
    void sendGameOver(List<Integer> scoreboard);
    void setMoney(int amount);
    void beginLearnSubject();
    void beginWorkOrStudyChoice();
    void beginCourseRequest();
    void beginLosingKnowledge();
    void beginOfferedMark();
    void beginMatekingChoice();
    void beginOvertimeWork();
    void beginUnregisterSubject();
    Socket getSocket();
    void showSubjectRegistrationWindow();
    void activate();
    void close();
}

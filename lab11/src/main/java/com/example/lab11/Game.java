package com.example.lab11;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Game {
    private Player infoPlayer1;
    private Player infoPlayer2;
    private String gameDetails;
    private String content="Avioane";

    public Game() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate gameDate=LocalDate.now();
        this.gameDetails = content+ " " +dtf.format(gameDate)+ " player1";
    }

    public String getGameDetails() {
        return gameDetails;
    }

    public Player getInfoPlayer1() {
        return infoPlayer1;
    }

    public void setInfoPlayer1(Player infoPlayer1) {
        this.infoPlayer1 = infoPlayer1;
    }

    public Player getInfoPlayer2() {
        return infoPlayer2;
    }

    public void setInfoPlayer2(Player infoPlayer2) {
        this.infoPlayer2 = infoPlayer2;
    }

    public void setGameDetails(String gameDetails) {
        this.gameDetails = gameDetails;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

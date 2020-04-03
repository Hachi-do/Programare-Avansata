package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private List<Token> extractedTokens;
    Board board;

    public Token getTokenAtIndex(int index){
        return extractedTokens.get(index);
    }

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
        this.extractedTokens = new ArrayList<>();
        this.extractedTokens = Collections.synchronizedList(extractedTokens);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public List<Token> getExtractedTokens() {
        return extractedTokens;
    }

    public synchronized Token extractToken() {
        if (!board.tokens.isEmpty()) {
            Token temp = board.tokens.get(0);
            board.tokens.remove(0);
            return temp;
        }
        return null;
    }


    @Override
    public synchronized void run() {
        Token newToken = extractToken();
        while (newToken != null) {
            System.out.println(this.name + " extracts: " + newToken.getNumber());
            this.extractedTokens.add(newToken);
            newToken = extractToken();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

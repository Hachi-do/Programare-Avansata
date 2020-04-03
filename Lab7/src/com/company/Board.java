package com.company;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    List<Token> tokens;
    private int numberOfTokens;
    private int maxValueToken;

    public Board(int numberOfTokens, int maxValueToken) {
        this.maxValueToken = maxValueToken;
        this.numberOfTokens = numberOfTokens;
        this.tokens = new ArrayList<>(numberOfTokens);
        this.tokens = Collections.synchronizedList(tokens);
    }

    public void getTokens() {
        for (Token i : tokens
        ) {
            System.out.print(i.getNumber() + " ");
        }
    }

    public int getNumberOfTokens() {
        return numberOfTokens;
    }

    public void generateBoard() {
        int valid = 0;
        boolean[] usedToken = new boolean[maxValueToken];
        for (int i = 0; i < numberOfTokens; i++) {
            int random = (int) (Math.random() * maxValueToken);
            Token token = new Token();
            token.setNumber("" + random);
            while (tokens.contains(token)) {
                random = (int) (Math.random() * maxValueToken);
                token.setNumber("" + random);

            }
            if (valid > maxValueToken || usedToken[random] == true) {
                token.setNumber("blank");
            }
            tokens.add(token);
            usedToken[random] = true;
            valid++;
        }
        Collections.shuffle(tokens);
    }
}
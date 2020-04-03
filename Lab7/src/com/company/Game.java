package com.company;

public class Game {

    public int getPoints(Player player) {
        int length = player.board.getNumberOfTokens()/2;
        int seqMax = 0;
        int seq = 0;
        int[] difference = new int[length];
        for (int i = 1; i < length -1; i++) {
            Token token1 = player.getTokenAtIndex(i-1);
            Token token2 = player.getTokenAtIndex(i);

            if (token1.getNumber().compareTo("blank")!=0 && token2.getNumber().compareTo("blank")!=0)
                {
                    int number1 = Integer.parseInt(token1.getNumber());
                    int number2 = Integer.parseInt(token2.getNumber());
                    difference[i] = number1 - number2;
                }else {
                    difference[i]=difference[i-1];
                }

        }
        for (int i = 0; i < length-1; i++) {
            if (difference[i] == difference[i + 1] && difference[i]!=0) seq++;
            if (seq > seqMax) {
                seqMax = seq;
            }
        }
        return seqMax;
    }

    public Game() throws InterruptedException {
            final Board board = new Board(20, 30);
            board.generateBoard();

            Player player1 = new Player("player1", board);
            Player player2 = new Player("player2", board);

            final Thread thread1 = new Thread(player1);
            final Thread thread2 = new Thread(player2);

            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();


            printPlayerStats(player1);
            printPlayerStats(player2);
            if (getPoints(player1) > getPoints(player2)) {
                System.out.println(player1.getName()+" won");
            } else if (getPoints(player1) < getPoints(player2)) {
                System.out.println(player2.getName()+" won");
            } else {
                System.out.println("Draw");
            }
        }

        private static void printPlayerStats (Player player){
            System.out.println(player.getName() + " tokens: ");
            player.getExtractedTokens().forEach(token -> System.out.print(token.getNumber() + " "));
            System.out.println();
        }


    }

package com.company;


import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);
    int op;
    Game game;
    ConfigGame confGame;


    public Menu(Game game, ConfigGame confGame) {
        this.game = game;
        this.confGame = confGame;
    }

    public void escullJoc() {
        do {
            System.out.println();
            System.out.println(" ESCULL UN JOC");
            System.out.println("_______________");
            System.out.println(" 1= Daus");
            System.out.println(" 2= Parxis");
            System.out.println(" 3= Tic Tac Toe");
            System.out.println(" 4= Sortir");
            System.out.println("_______________");
            op = scan.nextInt();

        } while (op > 4 || op < 1);
        if (op == 4) game.sortir = true;
        else confGame.setJoc(op);

    }

    public void mostraDaus() {


        do {
            System.out.println("JOC DELS DAUS");
            System.out.println("______________");
            System.out.println(" 1= play");
            System.out.println(" 2= Settings");
            System.out.println(" 3= Sortir");
            System.out.println("______________");
            op = scan.nextInt();
            switch (op) {
                case 1:
                    game.play();
                    break;
                case 2:
                    menuSettings();
                    break;
                case 3:
                    System.out.println("Sortir");

                    break;
                default:
                    System.out.println("Oooops! només 1-2-3");
                    break;
            }
        } while (op != 3);


    }

    private void menuSettings() {
        do {
            System.out.println("      MENU");
            System.out.println("___________________");


            System.out.println(" 1= Game settings");
            System.out.println(" 2= Player settings");
            System.out.println(" 3= Return");
            System.out.println("___________________");

            op = scan.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Settings for game");
                    settingsGame();
                    break;
                case 2:
                    System.out.println("Settings player");
                    settingsPlayer();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Oooops! només 1-2-3");
                    break;
            }
        } while (op != 3);
        op = 0;
    }


    private void settingsGame() {
        System.out.println("Nivell de joc?");
        confGame.setLevel(scan.nextInt());

    }

    private void settingsPlayer() {
        System.out.println("Escull un player   (1-9)");
        confGame.setNumPlayer(scan.nextInt());

    }

}

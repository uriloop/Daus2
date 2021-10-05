package com.company;


public class Game {
    Menu menuPrincipal;
    ConfigGame confGame;
    Daus daus = new Daus();
    boolean sortir;
    private int partidesGuanyades=0;
    private int partidesJugades=0;

    public int getPartidesGuanyades() {
        return partidesGuanyades;
    }

    public void setPartidesGuanyades() {
        this.partidesGuanyades++;
    }

    public int getPartidesJugades() {
        return partidesJugades;
    }

    public void setPartidesJugades() {
        this.partidesJugades ++;
    }

    public Game() {
        confGame = new ConfigGame();
        menuPrincipal = new Menu(this, confGame);
        sortir = false;
    }

    public void start() {
        do {
            menuPrincipal.escullJoc();
            if (!sortir) {
                switch (confGame.getJoc()) {
                    case 1:
                        menuPrincipal.mostraDaus();
                        break;
                    case 2:
                    case 3:
                        System.out.println("Encara no està implementat");

                        break;
                }
            }else{
                System.out.println("Sortint...");
                System.out.println("______________________________________");
                System.out.println("Partides jugades: "+getPartidesJugades());
                System.out.println("Partides guanyades: "+getPartidesGuanyades());
                System.out.println("______________________________________");
                System.out.println("App closed");
            }

        }
        while (!sortir);
    }


    public void play() {
        System.out.printf("Jugador %d\n jugant...(level %d)\n", confGame.getNumPlayer(), confGame.getLevel());
        daus.jugar();
        if (daus.guanya()) {
            System.out.println(" __    __  ____  ____   ____     ___  ____  \n" +
                    "|  |__|  ||    ||    \\ |    \\   /  _]|    \\ \n" +
                    "|  |  |  | |  | |  _  ||  _  | /  [_ |  D  )\n" +
                    "|  |  |  | |  | |  |  ||  |  ||    _]|    / \n" +
                    "|  `  '  | |  | |  |  ||  |  ||   [_ |    \\ \n" +
                    " \\      /  |  | |  |  ||  |  ||     ||  .  \\\n" +
                    "  \\_/\\_/  |____||__|__||__|__||_____||__|\\_|\n" +
                    "                                            ");
            System.out.println(daus.toString());
            confGame.setLevel(confGame.getLevel() + 1);
            setPartidesJugades();
            setPartidesGuanyades();
        }else setPartidesJugades();

    }


}

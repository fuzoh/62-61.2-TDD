package ch.hearc.bnd.tdd;

public class Game {

    public Game(TableauAffichage display) {
        Bowling bowling = new Bowling();
        display.seConnecter();
    }
}

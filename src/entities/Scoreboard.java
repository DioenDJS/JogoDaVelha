package entities;

public class Scoreboard {

    private Integer playerOne;

    private Integer playerTwo;

    public Scoreboard(){}

    public Scoreboard(Integer playerOne, Integer playerTwo){
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public Integer getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Integer playerOne) {
        this.playerOne = playerOne;
    }

    public Integer getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Integer playerTwo) {
        this.playerTwo = playerTwo;
    }

    @Override
    public String toString() {
        return "\n                   Jogador 1º [ " + playerOne + " x " + playerTwo + " ] Jogador 2º ";
    }
}

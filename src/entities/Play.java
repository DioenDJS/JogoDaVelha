package entities;

import utils.ConsoleColors;

public class Play {

    private String[][] tabuleiro;

    private Scoreboard scoreboard;

    public Play(){

        tabuleiro = new String[3][3];
        scoreboard = new Scoreboard(0,0);
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    private void setTabuleiro(String[][] tabuleiro) { this.tabuleiro = tabuleiro; }

    public Scoreboard getScoreboard() {
        return scoreboard;
    }

    public void setValueBoard(int positionsI, int positionsJ, String sinal){
        this.tabuleiro[positionsI][positionsJ] = sinal;
        setTabuleiro(this.tabuleiro);
    }

    public void getInitTabuleiro(){
        int layoutNumericoTabuleiro = 1;
        this.scoreboard.toString();
        for (int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro[i].length; j++) {
                    tabuleiro[i][j] = String.valueOf(layoutNumericoTabuleiro++);
            }
        }
        setTabuleiro(this.tabuleiro);
    }
}

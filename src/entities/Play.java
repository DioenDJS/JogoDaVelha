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
        System.out.println(scoreboard.toString() + "\n");
        this.scoreboard.toString();
        for (int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro[i].length; j++) {
                    tabuleiro[i][j] = String.valueOf(layoutNumericoTabuleiro++);
            }
        }
        setTabuleiro(this.tabuleiro);
    }


    public StringBuilder getToString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro[i].length; j++) {
                s.append("|" + this.tabuleiro[i][j]);
            }
            s.append("|\n");
        }
        return s;
    }

    public StringBuilder getViewPalyerWinner(String[] positionWinner) {
        System.out.println(scoreboard.toString() + "\n");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro[i].length; j++) {
                String check = (i + "" + j);
                if(check.equals(positionWinner[0]) || check.equals(positionWinner[1]) || check.equals(positionWinner[2]) ){
                    s.append("|" + ConsoleColors.GREEN + this.tabuleiro[i][j] + ConsoleColors.RESET);
                }else {
                    s.append("|" + this.tabuleiro[i][j]);
                }
            }
            s.append("|\n");
        }
        return s;
    }

    public String getCheck(String sinal){


         if((tabuleiro[0][0].equals(sinal) && tabuleiro[0][1].equals(sinal) && tabuleiro[0][2].equals(sinal))){
            return  "00,01,02," + sinal;
         }

        if((tabuleiro[1][0].equals(sinal) && tabuleiro[1][1].equals(sinal) && tabuleiro[1][2].equals(sinal))){
            return  "10,11,12," + sinal;
        }

        if((tabuleiro[2][0].equals(sinal) && tabuleiro[2][1].equals(sinal) && tabuleiro[2][2].equals(sinal))){
            return  "20,21,22," + sinal;
        }

        if((tabuleiro[0][0].equals(sinal) && tabuleiro[1][0].equals(sinal) && tabuleiro[2][0].equals(sinal))){
            return "00,10,20," + sinal;
        }

        if((tabuleiro[0][1].equals(sinal) && tabuleiro[1][1].equals(sinal) && tabuleiro[2][1].equals(sinal))){
            return "01,11,21," + sinal;
        }

        if((tabuleiro[0][2].equals(sinal) && tabuleiro[1][2].equals(sinal) && tabuleiro[2][2].equals(sinal))){
            return "02,12,22," + sinal;
        }

        if((tabuleiro[0][0].equals(sinal) && tabuleiro[1][1].equals(sinal) && tabuleiro[2][2].equals(sinal))){
            return "00,11,22," + sinal;
        }
        if((tabuleiro[0][2].equals(sinal) && tabuleiro[1][1].equals(sinal) && tabuleiro[2][0].equals(sinal))){
            return "02,11,20," + sinal;
         }
        return "";
    }
}

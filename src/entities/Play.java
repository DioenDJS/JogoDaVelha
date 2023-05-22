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

    //recebe a posição pra ser checada e o sinal
    public String cpuChecaPosicaoVitoriaOuDerrota(String positionWinner, String sinal) {


        //separa o valor na virgula
        String[] positions = positionWinner.split(",");

        //preserva o valor que havia na posição a ser checada
        String guardaValor = tabuleiro[Integer.parseInt(positions[0])][Integer.parseInt(positions[1])];

        //seta o valor para validar
        setValueBoard(Integer.parseInt(positions[0]),Integer.parseInt(positions[1]), sinal);

        //checando se o adiversirio vence
        String existe = getCheck(sinal);

        //retorna valor pra posição
        setValueBoard(Integer.parseInt(positions[0]),Integer.parseInt(positions[1]), guardaValor);

        if(existe.isEmpty()){
           return "";
        }

        return positionWinner;
    }
}

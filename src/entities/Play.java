package entities;

import entities.enums.PositionEnum;
import utils.ConsoleColors;

public class Play {

    private String[][] tabuleiro;

    public Play(){

        tabuleiro = new String[3][3];
    }

    public String[][] getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(String[][] tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public void getInitTabuleiro(){
        int layoutNumericoTabuleiro = 1;
        for (int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro[i].length; j++) {
                    tabuleiro[i][j] = String.valueOf(layoutNumericoTabuleiro++);
            }
        }
        setTabuleiro(this.tabuleiro);
    }

    public Boolean getMove(String escolha, String sinal){
        boolean jogadaFeita;
        String position = PositionEnum.getDescricao(escolha);

        String[] positions = position.split(",");

        String value = tabuleiro[Integer.parseInt(positions[0])][Integer.parseInt(positions[1])];

        if(value.equals("X") || value.equals("O")){
            System.out.println("Este "+ ConsoleColors.RED + "campo "+ ConsoleColors.RESET +"esta "+ ConsoleColors.RED + "prenchido" + ConsoleColors.RESET + "! ");
            return false;
        }else {
            this.tabuleiro[Integer.parseInt(positions[0])][Integer.parseInt(positions[1])] = sinal;

            setTabuleiro(this.tabuleiro);


            this.getTabuleiro();
            return true;
        }
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

    public String getCheck(String sinal){

         if(
                 (tabuleiro[0][0].equals(sinal) && tabuleiro[0][1].equals(sinal) && tabuleiro[0][2].equals(sinal)) ||
                 (tabuleiro[1][0].equals(sinal) && tabuleiro[1][1].equals(sinal) && tabuleiro[1][2].equals(sinal)) ||
                 (tabuleiro[2][0].equals(sinal) && tabuleiro[2][1].equals(sinal) && tabuleiro[2][2].equals(sinal)) ||
                 (tabuleiro[0][0].equals(sinal) && tabuleiro[1][0].equals(sinal) && tabuleiro[2][0].equals(sinal)) ||
                 (tabuleiro[0][1].equals(sinal) && tabuleiro[1][1].equals(sinal) && tabuleiro[2][1].equals(sinal)) ||
                 (tabuleiro[0][2].equals(sinal) && tabuleiro[1][2].equals(sinal) && tabuleiro[2][2].equals(sinal)) ||
                 (tabuleiro[0][0].equals(sinal) && tabuleiro[1][1].equals(sinal) && tabuleiro[2][2].equals(sinal)) ||
                 (tabuleiro[0][2].equals(sinal) && tabuleiro[1][1].equals(sinal) && tabuleiro[2][0].equals(sinal))

         ){
             return sinal;
         }
//         String twoLine = tabuleiro[0][0]+ ","+ tabuleiro[0][1] + ", "+ tabuleiro[0][2];
//         String treeLine = tabuleiro[0][0]+ ","+ tabuleiro[0][1] + ", "+ tabuleiro[0][2];
        return "";
    }
}

package service;

import entities.Play;
import entities.Player;
import entities.enums.PositionEnum;
import utils.Messagens;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlayService {

    public void jogoEmProgresso(Play play, List<Player> playerList, Scanner input){
        int totalJogadas = 9;
        boolean replayGame;
        do {
             play.getInitTabuleiro();

            System.out.println(play.getToString());

            for (int i = 0; i < totalJogadas; i++) {

                int vezDoJogador = (i + 1) % 2 == 0 ? 1 : 0;

                String escolha;

                boolean cpu = playerList.get(vezDoJogador).getName().equals("CPU") ? true : false ;
                if(!cpu) {
                    Messagens.escolhorPosição(playerList.get(vezDoJogador).getColor() + (vezDoJogador + 1), playerList.get(vezDoJogador).getName());
                    escolha = input.nextLine();
                }else{
                    String descricao = getCheckDois(play, playerList.get(vezDoJogador).getSimbolo());

                    try {
                        escolha = PositionEnum.getId(descricao);
                    }catch (RuntimeException e){
                        throw new NumberFormatException(e.getMessage());
                    }
                    Messagens.escolhorPosição(playerList.get(vezDoJogador).getColor() + (vezDoJogador + 1), playerList.get(vezDoJogador).getName(), Integer.parseInt(escolha));
                }

                if(!jogar(play, escolha, playerList.get(vezDoJogador).getSimbolo(), cpu)) {
                    i--;
                    continue;
                }

                System.out.println(play.getToString());

                String returnSimboloDoVencedor = play.getCheck(playerList.get(vezDoJogador).getSimbolo());

                String[] simboloDoVencedor = returnSimboloDoVencedor.split(",");

                if(returnSimboloDoVencedor.equals("")&& i < 8){
                    continue;
                }if(returnSimboloDoVencedor.equals("") && i == 8){
                    Messagens.resultadoDaPartida();
                    break;
                } else if (simboloDoVencedor[3].equals("X") || simboloDoVencedor[3].equals("O")) {
                    Player playerWinner = playerList.get(0).getSimbolo().equals(simboloDoVencedor[3]) ? playerList.get(0) : playerList.get(1);

                    Messagens.resultadoDaPartida(playerWinner.getColor(), playerWinner.getName());
                    String[] positionWinnewr = {simboloDoVencedor[0], simboloDoVencedor[1], simboloDoVencedor[2] };

                    if(playerList.get(0).getSimbolo().equals(simboloDoVencedor[3])){
                        play.getScoreboard().setPlayerOne(play.getScoreboard().getPlayerOne() + 1);
                    }else{
                        play.getScoreboard().setPlayerTwo(play.getScoreboard().getPlayerTwo() + 1);
                    }

                    System.out.println(play.getViewPalyerWinner(positionWinnewr));
                    break;
                }

            }

           replayGame = jogarNovamente(input);

        }while (replayGame);
    }

    public Boolean jogar(Play play, String escolha, String sinal, boolean cpu){

        String position = PositionEnum.getDescricao(escolha);

        if(position == null){
            Messagens.valorInvalidoDigitado();
            return false;
        }

        String[] positions = position.split(",");

        String value = play.getTabuleiro()[Integer.parseInt(positions[0])][Integer.parseInt(positions[1])];

        if(!validandoposicaoNoTabuleiro(value, cpu)){
            return false;
        }else {
            play.setValueBoard(Integer.parseInt(positions[0]),Integer.parseInt(positions[1]), sinal);
            play.getTabuleiro();
            return true;
        }
    }

    private boolean validandoposicaoNoTabuleiro(String sinal, boolean cpu){
        if((sinal.equals("X") || sinal.equals("O")) && cpu == true){
            return false;
        }else if((sinal.equals("X") || sinal.equals("O")) && cpu == false) {
            Messagens.campoPrenchido();
            return false;
        }
        return true;
    }

    public boolean jogarNovamente(Scanner input){
        char letter;
        do {
            Messagens.jogarNovamente();
            letter = input.next().charAt(0);
            input.nextLine();

            if(!(letter == 'S' || letter == 's' || letter == 'N' || letter == 'n')){
                Messagens.valorInvalidoDigitado();
                letter = ' ';
            }
        }while(letter == ' ');

        if (letter == 'S' || letter == 's') {
            return true;
        } else{
            return false;
        }
    }

    public String getCheckDois(Play play, String sinal) {

        String sinalAdversario = sinal.equals("X") ? "O" : "X";

        String[] posiçõesRestantes = listaPosicoesDoTabuleiro(play, sinal);

        //CPU verifica se esta por uma jogade de ganhar
        for (int i = 1; i <= 9; i++) {
            if(posiçõesRestantes[i].equals(" ")){
                continue;
            }
            String e =  play.cpuChecaPosicaoVitoriaOuDerrota(PositionEnum.getDescricao(String.valueOf(i)), sinal);
            if(!e.isEmpty()){
                return e;
            }
        }

        //CPU verifica se adversario esta por uma jogade de ganhar
        for (int i = 1; i <= 9; i++) {

            if(posiçõesRestantes[i].equals(" ")){
                continue;
            }
           String e =  play.cpuChecaPosicaoVitoriaOuDerrota(PositionEnum.getDescricao(String.valueOf(i)), sinalAdversario);
           if(!e.isEmpty()){
               return e;
           }
        }

        //CPU se não estiver por uma jogada de ganhar ou de perder escolhe um posição valida
        return cupJogaEmPosicaoValida(play, sinal);
    }
    public String cupJogaEmPosicaoValida(Play play, String sinal){

        String[] posicoesRestantes = listaPosicoesDoTabuleiro(play, sinal);
        int tamnaho = posicoesRestantes.length;
        Random numberRandom = new Random();
        int escolhaIntn;

        do{
            escolhaIntn = numberRandom.ints(1, tamnaho ).findFirst().getAsInt();
        }while (posicoesRestantes[escolhaIntn].equals(" "));
        return posicoesRestantes[escolhaIntn];
    }

    public String[] listaPosicoesDoTabuleiro(Play play, String sinal){

        String sinalAdversario = sinal.equals("X") ? "O" : "X";
        String[] posicoesRestantes = new String[10];
        String[][] tabuleiroPosicaoValida =  play.getTabuleiro();
        int contador = 1;

        for (int i = 0; i < tabuleiroPosicaoValida.length; i++) {
            for (int j = 0; j < tabuleiroPosicaoValida[i].length; j++) {
                if(!tabuleiroPosicaoValida[i][j].equals(sinalAdversario) && !tabuleiroPosicaoValida[i][j].equals(sinal)){
                    posicoesRestantes[contador] = i + "," + j;
                }else{
                    posicoesRestantes[contador] = " ";
                }
                contador++;
            }
        }

        return posicoesRestantes;
    }
}

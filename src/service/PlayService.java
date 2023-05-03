import entities.Play;
import entities.Player;
import entities.enums.PositionEnum;
import utils.ConsoleColors;

import java.util.List;
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

                System.out.print("Jogador " + playerList.get(vezDoJogador).getColor() + (vezDoJogador + 1) + "º " + playerList.get(vezDoJogador).getName() + ConsoleColors.RESET + " escolha uma posição de 1 a 9 : ");
                String escolha = input.nextLine();

                if(!getMove(play, escolha, playerList.get(vezDoJogador).getSimbolo())) {
                    i--;
                    continue;
                }

                System.out.println(play.getToString());

                String returnSimboloDoVencedor = play.getCheck(playerList.get(vezDoJogador).getSimbolo());

                String[] simboloDoVencedor = returnSimboloDoVencedor.split(",");

                if(returnSimboloDoVencedor.equals("")&& i < 8){
                    continue;
                }if(returnSimboloDoVencedor.equals("") && i == 8){
                    System.out.println(ConsoleColors.YELLOW + "Deu velha!" + ConsoleColors.RESET);
                    break;
                } else if (simboloDoVencedor[3].equals("X") || simboloDoVencedor[3].equals("O")) {
                    Player playerWinner = playerList.get(0).getSimbolo().equals(simboloDoVencedor[3]) ? playerList.get(0) : playerList.get(1);

                    System.out.println("Jogador " + playerWinner.getColor() + playerWinner.getName() + ConsoleColors.RESET + " venceu!");
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

    public Boolean getMove(Play play, String escolha, String sinal){
        boolean jogadaFeita;
        String position = PositionEnum.getDescricao(escolha);

        if(position == null){
            System.out.println("Voce digitou um valor " + ConsoleColors.RED + "invalido"+ ConsoleColors.RESET +"!");
            return false;
        }

        String[] positions = position.split(",");

        String value = play.getTabuleiro()[Integer.parseInt(positions[0])][Integer.parseInt(positions[1])];

        if(value.equals("X") || value.equals("O")){
            System.out.println("Este "+ ConsoleColors.RED + "campo "+ ConsoleColors.RESET +"esta "+ ConsoleColors.RED + "prenchido" + ConsoleColors.RESET + "! ");
            return false;
        }else {
            play.setValueBoard(Integer.parseInt(positions[0]),Integer.parseInt(positions[1]), sinal);
            play.getTabuleiro();
            return true;
        }
    }
}

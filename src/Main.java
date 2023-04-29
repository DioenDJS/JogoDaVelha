import utils.ConsoleColors;
import entities.Play;
import entities.Player;
import entities.enums.PositionEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Player player = new Player();

        List<Player> playerList = new ArrayList<>();

        Play play = new Play();

        String colorPlayer;
        int jogadas = 9;

        while (playerList.size() < 2){
            try {
                colorPlayer = playerList.size() == 0 ? ConsoleColors.PURPLE : ConsoleColors.CYAN;
                System.out.print("Player " + colorPlayer + (playerList.size() + 1) + ConsoleColors.RESET + " digite seu nick name: ");
                String name = input.nextLine();

                String simbolo;

                if(playerList.size() <= 0) {
                    System.out.print("Player " + ConsoleColors.PURPLE + (playerList.size() + 1) + ConsoleColors.RESET + " escolha o sinal \"X\" ou \"O\" : ");
                    simbolo = input.nextLine();
                    if(!simbolo.equals("X") && !simbolo.equals("O")){
                        System.out.println("Voce digitou um valor " + ConsoleColors.RED + "invalido"+ ConsoleColors.RESET +"!");
                        continue;
                    }
                }else{
                    simbolo = playerList.get(0).getSimbolo().equals("X") ? "O" : "X";

                }
                playerList.add(player = new Player(name, simbolo));
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

        play.getInitTabuleiro();

        System.out.println(play.getToString());

        for (int i = 0; i < jogadas; i++) {

            int vezDoJogador = (i+1)%2 == 0 ? 1 : 0;

            colorPlayer = vezDoJogador == 0 ? ConsoleColors.PURPLE : ConsoleColors.CYAN;
            System.out.print("Jogador " + colorPlayer +(vezDoJogador+1) + "º "+ playerList.get(vezDoJogador).getName() + ConsoleColors.RESET +" escolha uma posição de 1 a 9 : ");
            String escolha = input.nextLine();

            boolean next = play.getMove(escolha, playerList.get(vezDoJogador).getSimbolo());

            if(next == false){
                i--;
                continue;
            }
            System.out.println(play.getToString());

            String simboloDoVencedor = play.getCheck(playerList.get(vezDoJogador).getSimbolo());

            if(simboloDoVencedor.equals("X") || simboloDoVencedor.equals("O")){
                Player playerWinner = playerList.get(0).getSimbolo().equals(simboloDoVencedor) ? playerList.get(0): playerList.get(1);
                colorPlayer = playerList.get(0).getSimbolo().equals(simboloDoVencedor) ? ConsoleColors.PURPLE : ConsoleColors.CYAN;
                System.out.println("Jogador " + colorPlayer + playerWinner.getName() + ConsoleColors.RESET + " venceu!");
                break;
            }
            if(i == 8){
                System.out.println(ConsoleColors.YELLOW +"Deu velha!"+ ConsoleColors.RESET);
        }
    }



}
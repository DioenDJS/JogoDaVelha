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

        int jogadas = 9;

        while (playerList.size() < 2){
            try {
                System.out.print("Player " + (playerList.size() + 1) + " digite seu nick name: ");
                String name = input.nextLine();

                String simbolo;

                if(playerList.size() <= 0) {
                    System.out.print("Player " + (playerList.size() + 1) + " escolha o sinal \"X\" ou \"O\" : ");
                    simbolo = input.nextLine();
                    if(!simbolo.equals("X") && !simbolo.equals("O")){
                        System.out.println("Voce digitou um valor invalido!");
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

            System.out.print("Jogador " + (vezDoJogador+1) + "º "+ playerList.get(vezDoJogador).getName() + " escolha uma posição de 1 a 9 : ");
            String escolha = input.nextLine();

            boolean next = play.getMove(escolha, playerList.get(vezDoJogador).getSimbolo());

            if(next == false){
                i--;
                continue;
            }
            System.out.println(play.getToString());

            String simboloDoVencedor = play.getCheck(playerList.get(vezDoJogador).getSimbolo());

            if(simboloDoVencedor.equals("X") || simboloDoVencedor.equals("O")){
                String nome = playerList.get(0).getSimbolo().equals(simboloDoVencedor) ? playerList.get(0).getName() : playerList.get(1).getName();
                System.out.println("Jogador " + nome + " venceu!");
                break;
            }
            if(i == 8){
                System.out.println(ConsoleColors.YELLOW +"Deu velha!"+ ConsoleColors.RESET);
        }
    }



}
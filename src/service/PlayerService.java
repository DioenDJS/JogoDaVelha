package service;

import entities.Player;
import utils.ConsoleColors;

import java.util.List;
import java.util.Scanner;

public class PlayerService {

    public List<Player> criandoJogadores(List<Player> playerList, Scanner input){

        System.out.println(" --------- Escolha ---------- ");
        System.out.println("| 1 - Player 1º vs   CPU     | ");
        System.out.println("| 2 - Player 1º vs Player 2º | ");
        System.out.println(" ---------------------------- ");
        int switchPlay = input.nextInt();

        boolean cpu = switchPlay == 1 ? true : false ;

        return cadastraJogadores(playerList, input, cpu);

    }

    private List<Player> cadastraJogadores(List<Player> playerList, Scanner input, boolean cpu){
        String colorPlayer;
        String simbolo;
        String name;

            try {
                while (playerList.size() < 2) {

                    if (playerList.size() >= 1 && cpu == true) {
                        name = "CPU";
                        colorPlayer = ConsoleColors.CYAN;
                    } else {
                        if(playerList.size() <= 0)
                            input.nextLine();
                        colorPlayer = playerList.size() == 0 ? ConsoleColors.PURPLE : ConsoleColors.CYAN;
                        System.out.print("Player " + colorPlayer + (playerList.size() + 1) + ConsoleColors.RESET + " digite seu nick name: ");
                        name = input.nextLine();
                    }

                    if (playerList.size() <= 0) {
                        System.out.print("Player " + ConsoleColors.PURPLE + (playerList.size() + 1) + ConsoleColors.RESET + " escolha o sinal \"X\" ou \"O\" : ");
                        simbolo = input.nextLine();
                        if (!simbolo.equals("X") && !simbolo.equals("O")) {
                            System.out.println("Voce digitou um valor " + ConsoleColors.RED + "invalido" + ConsoleColors.RESET + "!");
                            continue;
                        }
                    } else {
                        simbolo = playerList.get(0).getSimbolo().equals("X") ? "O" : "X";

                    }

                    playerList.add(new Player(name, simbolo, colorPlayer));
                }
                return playerList;

            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e.getMessage());
            }

    }
}

package service;

import entities.Player;
import utils.ClearConsole;
import utils.ConsoleColors;
import utils.Messagens;

import java.util.List;
import java.util.Scanner;

public class PlayerService {

    public List<Player> criandoJogadores(List<Player> playerList, Scanner input){

        Messagens.escolherJogadores();
        int switchPlay = input.nextInt();

        boolean cpu = switchPlay == 1 ? true : false ;

        ClearConsole.ClearConsole();
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
                        Messagens.digiteNomeJogador(colorPlayer, (playerList.size() + 1));
                        name = input.nextLine();
                    }

                    if (playerList.size() <= 0) {
                        Messagens.sinalJogador(ConsoleColors.PURPLE, (playerList.size() + 1));
                        simbolo = input.nextLine();
                        if (!simbolo.equals("X") && !simbolo.equals("O")) {
                            Messagens.valorInvalidoDigitado();
                            continue;
                        }
                    } else {
                        simbolo = playerList.get(0).getSimbolo().equals("X") ? "O" : "X";

                    }

                    playerList.add(new Player(name, simbolo, colorPlayer));
                }
                ClearConsole.ClearConsole();
                return playerList;

            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e.getMessage());
            }

    }
}

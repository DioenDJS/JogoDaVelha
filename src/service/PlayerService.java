package service;

import entities.Player;
import utils.ConsoleColors;

import java.util.List;
import java.util.Scanner;

public class PlayerService {

    public List<Player> criandoJogadores(List<Player> playerList, Scanner input){

        String colorPlayer;

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
                playerList.add(new Player(name, simbolo, colorPlayer));
            } catch (NullPointerException e) {
                System.out.println(e.getMessage());
            }
        }

        return playerList;
    }
}

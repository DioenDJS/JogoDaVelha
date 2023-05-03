import entities.Scoreboard;
import service.PlayService;
import service.PlayerService;
import utils.ConsoleColors;
import entities.Play;
import entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Player> playerList = new ArrayList<>();
        Play play = new Play();
        PlayerService playerService = new PlayerService();
        PlayService playService = new PlayService();

        Scanner input = new Scanner(System.in);

        playerList = playerService.criandoJogadores(playerList, input);

        playService.jogoEmProgresso(play, playerList, input);
        
    }
}
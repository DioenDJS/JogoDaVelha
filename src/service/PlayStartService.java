package service;

import entities.Play;
import entities.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayStartService {

    private final PlayerService playerService;
    private final PlayService playService;

    public PlayStartService(){
        playerService = new PlayerService();
        playService = new PlayService();
    }

    public void iniciarPartida() {

        List<Player> playerList = new ArrayList<>();
        Play play = new Play();

        Scanner input = new Scanner(System.in);

        playerService.criandoJogadores(playerList, input);

        playService.jogoEmProgresso(play, playerList, input);
    }
}

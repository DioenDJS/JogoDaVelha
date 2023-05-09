package utils;

public class Messagens {

    public static void escolherJogadores(){
        System.out.println(" --------- Escolha ---------- \n| 1 - Player 1º vs   CPU     |\n| 2 - Player 1º vs Player 2º |\n ----------------------------");
    }

    public static void jogarNovamente() {
        System.out.print("Desejam jogar novamente digite (S) - Sim ou (N) - Não : ");
    }

    public static void valorInvalidoDigitado(){
        System.out.printf("Voce digitou %s um valor invalido %s ! \n",ConsoleColors.RED, ConsoleColors.RESET);
    }

    public static void campoPrenchido() {
        System.out.printf("Este %s campo %s esta %s prenchido %s!\n", ConsoleColors.RED, ConsoleColors.RESET, ConsoleColors.RED, ConsoleColors.RESET);
    }

    public static void digiteNomeJogador(String colorJogador, int numeroJogador){
        System.out.printf("Player %s%d%s digite seu nick name: ",colorJogador, numeroJogador, ConsoleColors.RESET);
    }

    public static void sinalJogador(String colorJogador, int numeroJogador){
        System.out.printf("Player %s%d%s escolha o sinal \"X\" ou \"O\" : ", colorJogador, numeroJogador, ConsoleColors.RESET);
    }
    
    public static void resultadoDaPartida() {
        System.out.printf("%sDeu velha!%s\n", ConsoleColors.YELLOW,  ConsoleColors.RESET);
    }

    public static void resultadoDaPartida(String colorJogador, String nomeJogador) {
        System.out.printf("Jogador %s %s %s venceu! \n", colorJogador, nomeJogador, ConsoleColors.RESET);
    }

    public static void escolhorPosição(String colorJogador, String nomeJogador){
        System.out.printf("Jogador %sº %s %s escolha uma posição de 1 a 9 : ",colorJogador, nomeJogador, ConsoleColors.RESET);
    }

    public static void escolhorPosição(String colorJogador, String nomeJogador, int escolha){
        System.out.printf("Jogador %sº %s %s escolha uma posição de 1 a 9 : %d \n",colorJogador, nomeJogador, ConsoleColors.RESET, escolha);
    }

}

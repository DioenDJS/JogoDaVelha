package utils;

public class ClearConsole {
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); // Determina as propriedades atuais do sistema - java.lang.System.

            if(operatingSystem.contains("Windows")){ //método verifica se uma string contém uma sequência de caracteres - java.lang.String.

                /* ProcessBuilder classe é usada para criar processos do sistema operacional.
                 Cada ProcessBuilder instância gerencia uma coleção de atributos de processo.
                 O método start() método cria uma nova Process instância com esses atributos.
                 O método start() pode ser chamado repetidamente da mesma instância para
                 criar novos subprocessos com atributos idênticos ou relacionados. */
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");

                /* java.lang.ProcessBuilder
                inheritIO() Configura a origem e o destino da E/S padrão do subprocesso para serem os mesmos do processo Java atual.
                start() Inicia um novo processo usando os atributos deste construtor de processos. */
                Process startProcess = pb.inheritIO().start();

                /*java.lang.Process
                * Faz com que o thread atual espere, se necessário, até que o processo representado por este Processobjeto seja encerrado.*/
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

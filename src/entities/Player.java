package entities;

public class Player {

    private String name;
    private String simbolo;

    public Player(){}
    public Player(String name){
        this.name = name;
    }

    public Player(String name, String simbolo){
        this.name = name;
        this.simbolo = simbolo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}

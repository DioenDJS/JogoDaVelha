package entities;

public class Player {

    private String name;
    private String simbolo;
    private String color;

    public Player(){}
    public Player(String name){
        this.name = name;
    }

    public Player(String name, String simbolo, String color){
        this.name = name;
        this.simbolo = simbolo;
        this.color = color;
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

    public String getColor() { return color; }

    public void setColor(String color) { this.color = color; }
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}

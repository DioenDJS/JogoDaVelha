package entities.enums;

public enum PositionEnum {

    UM("1", "0,0"),
    DOIS("2", "0,1"),
    TRES("3", "0,2"),
    QUATRO("4", "1,0"),
    CINCO("5", "1,1"),
    SEIS("6", "1,2"),
    SETE("7", "2,0"),
    OITO("8", "2,1"),
    NOVE("9", "2,2");

    private String id;
    private String descricao;

    PositionEnum(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public static String getDescricao(String id) {
        for (PositionEnum p : PositionEnum.values()) {
            if(p.id.equals(id)){
                return p.getDescricao();
            }
        }
        return null;
    }

}

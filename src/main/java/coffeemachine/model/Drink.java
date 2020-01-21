package coffeemachine.model;

public enum Drink {
    TEA("T"),
    COFFEE("C"),
    CHOCOLATE("H"),
    JUICE("O");

    private final String key;

    Drink(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }


}

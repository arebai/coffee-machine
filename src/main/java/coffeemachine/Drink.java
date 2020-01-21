package coffeemachine;

public enum Drink {
    TEA("T"),
    COFFEE("C");

    private final String key;

    Drink(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }


}

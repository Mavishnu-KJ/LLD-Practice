package lld.vendingmachine;

public enum Coin {

    ONE(1), TWO(2), FIVE(5), TEN(10), TWENTY(20), FIFTY(50);

    private final int value;

    //Constructor
    Coin(int value) {
        this.value = value;
    }

    //Getter methods
    public int getValue() {
        return value;
    }
}

package lld.atm;

public class Card {
    private final String cardNumber;
    private final String accountNumber;
    private final String pin;
    private boolean isBlocked = false;

    //Constructor
    public Card(String cardNumber, String accountNumber, String pin) {
        this.cardNumber = cardNumber;
        this.accountNumber = accountNumber;
        this.pin = pin;
    }

    //Getter methods
    public String getCardNumber() {
        return cardNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    //Methods
    public boolean validatePin(String enteredPin){
        if(enteredPin.equals(pin) && !isBlocked){
            return true;
        }
        return false;
    }

    public void blockCard(){
        this.isBlocked = true;
    }

}

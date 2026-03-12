

/** process: "Оплата картой *XXXX: Z руб.", комиссия 2% */
public record CreditCard(String cardNumber, String holder) implements PaymentMethod {
    @Override
    public String process(double amount) {
        String last4 = cardNumber.length() >= 4 ? cardNumber.substring(cardNumber.length() - 4) : "****";
        return "Оплата картой *" + last4 + ": " + amount + " руб.";
    }

    @Override
    public double fee(double amount) {
        return amount * 0.02;
    }
}

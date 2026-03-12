package fa.com.lab2;

/** process: "Перевод через БАНК: Z руб.", комиссия 50 руб. */
public record BankTransfer(String bankName, String iban) implements PaymentMethod {
    @Override
    public String process(double amount) {
        return "Перевод через " + bankName + ": " + amount + " руб.";
    }

    @Override
    public double fee(double amount) {
        return 50;
    }
}

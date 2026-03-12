

/** process: "Криптоплатёж (ВАЛЮТА): Z руб.", комиссия 1.5% */
public record CryptoWallet(String address, String currency) implements PaymentMethod {
    @Override
    public String process(double amount) {
        return "Криптоплатёж (" + currency + "): " + amount + " руб.";
    }

    @Override
    public double fee(double amount) {
        return amount * 0.015;
    }
}

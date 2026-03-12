

/**
 * Практика 2, Задание 2.2: sealed interface — CreditCard, BankTransfer, CryptoWallet.
 */
public sealed interface PaymentMethod permits CreditCard, BankTransfer, CryptoWallet {
    String process(double amount);
    double fee(double amount);
}



/** Описание способа оплаты (без pattern matching в switch для совместимости с Java 17) */
public class PaymentProcessor {
    public static void describe(PaymentMethod pm) {
        if (pm instanceof CreditCard cc) {
            String last4 = cc.cardNumber().length() >= 4 ? cc.cardNumber().substring(cc.cardNumber().length() - 4) : "****";
            System.out.println("  Описание: Карта *" + last4 + ", владелец " + cc.holder());
        } else if (pm instanceof BankTransfer bt) {
            System.out.println("  Описание: Банк " + bt.bankName() + ", IBAN " + bt.iban());
        } else if (pm instanceof CryptoWallet cw) {
            System.out.println("  Описание: Адрес " + cw.address() + ", валюта " + cw.currency());
        }
    }
}

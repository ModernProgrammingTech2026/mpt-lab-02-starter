

/**
 * Практика 2, Задание 1.1: Банковский счёт.
 * Требования: приватные поля owner, balance, accountNumber; статические totalAccounts, bankName;
 * статический блок, блок инициализации экземпляра, конструктор, deposit, withdraw, getTotalAccounts, toString.
 * @see <a href="https://aliebraheem-fun.github.io/Modern-Programming-Technologies/#/practice2">Практика 2</a>
 */
public class BankAccount {
    private final String owner;
    private double balance;
    private final String accountNumber;

    private static int totalAccounts = 0;
    private static String bankName;

    static {
        bankName = "Java Bank";
        System.out.println("Банковская система инициализирована");
    }

    {
        totalAccounts++;
        System.out.println("Создание счёта #" + totalAccounts);
    }

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
        this.accountNumber = "ACC-" + totalAccounts;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Ошибка: сумма должна быть положительной");
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Ошибка: недостаточно средств");
            return;
        }
        balance -= amount;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s: %.2f руб.", accountNumber, owner, balance);
    }

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Алиса", 1000);
        BankAccount a2 = new BankAccount("Борис", 500);

        System.out.println(a1);
        System.out.println(a2);

        a1.deposit(500);
        System.out.println("После пополнения: " + a1);

        a1.withdraw(200);
        System.out.println("После снятия: " + a1);

        a1.withdraw(5000);

        a2.deposit(-100);

        System.out.println("Всего счетов: " + BankAccount.getTotalAccounts());
    }
}

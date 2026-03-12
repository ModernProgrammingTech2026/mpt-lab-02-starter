package fa.com.lab2;

/**
 * Абстрактный класс для Задания 2.1: name, baseSalary, calculateBonus(), totalCompensation(), toString.
 */
public abstract class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public String getName() { return name; }
    public double getBaseSalary() { return baseSalary; }

    public abstract double calculateBonus();

    public double totalCompensation() {
        return baseSalary + calculateBonus();
    }

    @Override
    public String toString() {
        double bonus = calculateBonus();
        return String.format("%s | Оклад: %.1f | Бонус: %.1f | Итого: %.1f", name, baseSalary, bonus, totalCompensation());
    }
}

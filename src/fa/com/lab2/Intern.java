package fa.com.lab2;

/** Бонус = фиксированные 10000 */
public class Intern extends Employee {
    public Intern(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public double calculateBonus() {
        return 10000;
    }
}

package fa.com.lab2;

/** Бонус = baseSalary * 0.15 + teamSize * 5000 */
public class Manager extends Employee {
    private final int teamSize;

    public Manager(String name, double baseSalary, int teamSize) {
        super(name, baseSalary);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.15 + teamSize * 5000;
    }
}

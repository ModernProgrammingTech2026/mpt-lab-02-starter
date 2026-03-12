

/** Бонус = baseSalary * 0.12 */
public class Developer extends Employee {
    @SuppressWarnings("unused")
    private final String language;

    public Developer(String name, double baseSalary, String language) {
        super(name, baseSalary);
        this.language = language;
    }

    @Override
    public double calculateBonus() {
        return baseSalary * 0.12;
    }
}

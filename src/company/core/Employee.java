package company.core;

/**
 * Практика 2, Задание 1.2 — исходный класс для анализа модификаторов доступа.
 * В другом пакете (company.app) код обращается к полям/методам — определите, что компилируется.
 */
public class Employee {
    public String name;
    protected int age;
    double salary;              // package-private
    private String password;

    public Employee(String name, int age, double salary, String password) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.password = password;
    }

    public String getRole() {
        return "Employee";
    }

    protected void promote(double raise) {
        this.salary += raise;
    }

    void printSummary() {
        System.out.println(name + ", " + age + " лет, " + salary + " руб.");
    }

    private boolean validatePassword(String input) {
        return password.equals(input);
    }
}


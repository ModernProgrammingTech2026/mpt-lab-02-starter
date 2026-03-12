package fa.com.lab2;

/**
 * Практика 2, Задание 1.2 — исправленная инкапсуляция: все поля private,
 * геттеры для name, age, salary; promote и printSummary public; authenticate() вызывает validatePassword.
 */
public class EmployeeFixed {
    private String name;
    private int age;
    private double salary;
    private String password;

    public EmployeeFixed(String name, int age, double salary, String password) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.password = password;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public double getSalary() { return salary; }

    public String getRole() {
        return "Employee";
    }

    public void promote(double raise) {
        this.salary += raise;
    }

    public void printSummary() {
        System.out.println(name + ", " + age + " лет, " + salary + " руб.");
    }

    private boolean validatePassword(String input) {
        return password != null && password.equals(input);
    }

    public boolean authenticate(String input) {
        return validatePassword(input);
    }
}

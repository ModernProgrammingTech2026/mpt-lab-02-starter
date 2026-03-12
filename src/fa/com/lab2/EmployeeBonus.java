package fa.com.lab2;

/**
 * Практика 2, Задание 2.1: иерархия сотрудников — абстрактный Employee, Manager, Developer, Intern.
 */
public class EmployeeBonus {
    public static void main(String[] args) {
        Employee[] team = {
            new Manager("Ольга", 120000, 5),
            new Developer("Андрей", 95000, "Java"),
            new Developer("Мария", 100000, "Python"),
            new Intern("Стажёр Петя", 30000)
        };

        System.out.println("=== Расчёт бонусов ===");
        double totalBudget = 0;
        for (Employee e : team) {
            System.out.println(e);
            totalBudget += e.totalCompensation();
        }
        System.out.printf("%nОбщий бюджет: %.0f руб.%n", totalBudget);
    }
}

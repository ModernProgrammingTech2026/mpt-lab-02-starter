package company.app;

import company.core.Employee;

/**
 * Практика 2, Задание 1.2 — анализ: какие строки A–H скомпилируются?
 * Строки с ошибками оставлены закомментированными, чтобы проект компилировался.
 */
public class HRSystem {
    public static void main(String[] args) {
        Employee emp = new Employee("Иван", 30, 80000, "secret");

        System.out.println(emp.name);            // A — компилируется (public)
        // System.out.println(emp.age);         // B — не компилируется (protected: доступен только в подклассе или том же пакете)
        // System.out.println(emp.salary);      // C — не компилируется (package-private, другой пакет)
        // System.out.println(emp.password);    // D — не компилируется (private)
        System.out.println(emp.getRole());       // E — компилируется (public)
        // emp.promote(5000);                   // F — не компилируется (protected из другого пакета)
        // emp.printSummary();                  // G — не компилируется (package-private)
        // emp.validatePassword("secret");      // H — не компилируется (private)
    }
}


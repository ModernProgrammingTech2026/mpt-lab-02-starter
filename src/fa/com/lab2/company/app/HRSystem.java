package fa.com.lab2.company.app;

import fa.com.lab2.company.core.Employee;

/**
 * Практика 2, Задание 1.2 — анализ: какие строки A–H скомпилируются?
 * A: emp.name — да (public)
 * B: emp.age — да (protected, подкласс/пакет — нет; другой пакет — да для доступа к полю? Нет — protected только в подклассе)
 * C: emp.salary — нет (package-private, другой пакет)
 * D: emp.password — нет (private)
 * E: emp.getRole() — да (public)
 * F: emp.promote(5000) — нет в другом пакете (protected только для подкласса)
 * G: emp.printSummary() — нет (package-private)
 * H: emp.validatePassword — нет (private)
 */
public class HRSystem {
    public static void main(String[] args) {
        Employee emp = new Employee("Иван", 30, 80000, "secret");

        System.out.println(emp.name);            // A — компилируется
        // System.out.println(emp.age);         // B — не компилируется (protected: только подкласс)
        // System.out.println(emp.salary);      // C — не компилируется (package-private)
        // System.out.println(emp.password);    // D — не компилируется (private)
        System.out.println(emp.getRole());       // E — компилируется
        // emp.promote(5000);                   // F — не компилируется (protected)
        // emp.printSummary();                  // G — не компилируется (package-private)
        // emp.validatePassword("secret");      // H — не компилируется (private)
    }
}

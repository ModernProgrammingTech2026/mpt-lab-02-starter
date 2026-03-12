

import java.util.ArrayList;
import java.util.List;

/**
 * Практика 2, Задание 1.3: var — 5 рабочих примеров, 4 некомпилируемых (в комментариях).
 */
public class VarDemo {
    // var field = 10; // Не компилируется — var нельзя использовать для полей класса

    public static void main(String[] args) {
        // 5 рабочих примеров
        var num = Integer.valueOf(42);
        System.out.println(num + " -> " + num.getClass().getSimpleName());

        var text = "Java";
        System.out.println(text + " -> " + text.getClass().getSimpleName());

        var list = new ArrayList<>(List.of("один", "два"));
        System.out.println(list + " -> " + list.getClass().getSimpleName());

        var arr = new int[]{1, 2, 3};
        System.out.println(java.util.Arrays.toString(arr) + " -> " + arr.getClass().getSimpleName());

        var account = new BankAccount("Test", 100);
        System.out.println("BankAccount -> " + account.getClass().getSimpleName());

        // 4 случая, где var не работает (оставлены в комментариях):
        // 1. var x; x = 5;           — var требует инициализации при объявлении
        // 2. void method(var param)  — var нельзя как тип параметра метода
        // 3. var field = 10;        — var нельзя для поля класса (см. выше)
        // 4. var n = null;           — тип не выводится из null
    }
}

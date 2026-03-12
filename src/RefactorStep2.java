

import java.util.*;
import java.util.function.*;

/**
 * Практика 2, Задание 7.1 Этап 2: лямбды заменены на ссылки на методы где возможно.
 * Нельзя заменить на ссылку на метод:
 * - (a, b) -> Integer.compare(a.length(), b.length()) — нужен компаратор по длине, нет готового метода с двумя аргументами.
 * - s -> s + "!" — выражение с константой, не вызов одного метода.
 * - () -> new ArrayList<>() — конструктор: можно ArrayList::new.
 * Можно: toUpper = String::toUpperCase, forEach = System.out::println, listFactory = ArrayList::new.
 */
public class RefactorStep2 {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>(Arrays.asList("Москва", "Берлин", "Токио", "Нью-Йорк", "Париж"));

        cities.sort((a, b) -> Integer.compare(a.length(), b.length())); // ссылкой нельзя: два аргумента, свой компаратор

        cities.forEach(System.out::println); // ссылка на метод

        Function<String, String> toUpper = String::toUpperCase; // ссылка на метод

        Predicate<String> isLong = s -> s.length() > 5; // лямбда (одно выражение, не прямой вызов метода с одним аргументом)

        Function<String, String> exclaim = s -> s + "!"; // нельзя ссылкой: конкатенация с константой

        Supplier<List<String>> listFactory = ArrayList::new; // ссылка на конструктор
    }
}

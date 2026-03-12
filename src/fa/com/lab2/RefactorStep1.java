package fa.com.lab2;

import java.util.*;
import java.util.function.*;

/**
 * Практика 2, Задание 7.1 Этап 1: анонимные классы заменены на лямбды.
 */
public class RefactorStep1 {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>(Arrays.asList("Москва", "Берлин", "Токио", "Нью-Йорк", "Париж"));

        cities.sort((a, b) -> Integer.compare(a.length(), b.length()));

        cities.forEach(city -> System.out.println(city));

        Function<String, String> toUpper = s -> s.toUpperCase();

        Predicate<String> isLong = s -> s.length() > 5;

        Function<String, String> exclaim = s -> s + "!";

        Supplier<List<String>> listFactory = () -> new ArrayList<>();
    }
}

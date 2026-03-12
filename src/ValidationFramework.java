

import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

/**
 * Практика 2, Задание 6.1 Часть B: @NotEmpty, @Range, Validator через Reflection.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotEmpty {
    String message() default "Поле не может быть пустым";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range {
    int min();
    int max();
    String message() default "Значение вне допустимого диапазона";
}

class RegistrationForm {
    @NotEmpty(message = "Имя обязательно")
    public String name;
    @NotEmpty
    public String email;
    @Range(min = 18, max = 120, message = "Возраст должен быть от 18 до 120")
    public int age;

    public RegistrationForm(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}

class Validator {
    public static List<String> validate(Object obj) {
        List<String> errors = new ArrayList<>();
        for (Field f : obj.getClass().getDeclaredFields()) {
            f.setAccessible(true);
            try {
                if (f.isAnnotationPresent(NotEmpty.class)) {
                    NotEmpty a = f.getAnnotation(NotEmpty.class);
                    Object val = f.get(obj);
                    if (val == null || val.toString().trim().isEmpty()) {
                        errors.add(a.message());
                    }
                }
                if (f.isAnnotationPresent(Range.class)) {
                    Range a = f.getAnnotation(Range.class);
                    int val = f.getInt(obj);
                    if (val < a.min() || val > a.max()) {
                        errors.add(a.message());
                    }
                }
            } catch (IllegalAccessException e) {
                errors.add("Ошибка доступа к полю: " + f.getName());
            }
        }
        return errors;
    }
}

public class ValidationFramework {
    public static void main(String[] args) {
        RegistrationForm valid = new RegistrationForm("Иван", "ivan@mail.ru", 25);
        RegistrationForm invalid = new RegistrationForm("", null, 15);

        System.out.println("=== Валидация корректной формы ===");
        List<String> errors1 = Validator.validate(valid);
        System.out.println(errors1.isEmpty() ? "Все поля валидны!" : errors1);

        System.out.println("\n=== Валидация некорректной формы ===");
        List<String> errors2 = Validator.validate(invalid);
        errors2.forEach(e -> System.out.println("  - " + e));
    }
}

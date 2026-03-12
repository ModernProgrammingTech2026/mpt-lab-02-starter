package fa.com.lab2;

import java.lang.annotation.*;

/**
 * Практика 2, Задание 6.1 Часть A: заполнить пропуски.
 * @Retention(RetentionPolicy.RUNTIME) — доступна во время выполнения через Reflection
 * @Target(ElementType.METHOD) — применяется к методам
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestInfo {
    String author();
    String date();
    String description() default "";
    int priority() default 5;
}

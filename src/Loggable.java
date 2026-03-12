

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/** Практика 2, Задание 2.3: default, static, private в интерфейсе */
public interface Loggable {
    String getComponentName();

    default void log(String message) {
        System.out.println("[" + formatTimestamp() + "] [" + getComponentName() + "] " + message);
    }

    default void logError(String message) {
        System.out.println("[" + formatTimestamp() + "] [" + getComponentName() + "] ОШИБКА: " + message);
    }

    private String formatTimestamp() {
        return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    static String getLogLevel() {
        return "INFO";
    }
}

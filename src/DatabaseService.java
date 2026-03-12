

/** Логирует подключение к БД */
public class DatabaseService implements Loggable {
    @Override
    public String getComponentName() {
        return "DatabaseService";
    }

    public void connect(String url) {
        log("Подключение к " + url);
        log("Подключение установлено");
    }
}

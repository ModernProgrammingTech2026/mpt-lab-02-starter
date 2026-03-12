
/** Логирует вход; при неудаче — logError */
public class AuthService implements Loggable {
    @Override
    public String getComponentName() {
        return "AuthService";
    }

    public void login(String username, boolean success) {
        if (success) {
            log("Вход пользователя: " + username + " — успешно");
        } else {
            logError("Вход пользователя: " + username + " — отказано");
        }
    }
}

package quarter1.javaCoreAdvancedLevel.lesson08.server;

public interface AuthService {
    String getNicknameByLoginAndPassword(String login, String password);
    boolean registration(String login, String password, String nickname);
}

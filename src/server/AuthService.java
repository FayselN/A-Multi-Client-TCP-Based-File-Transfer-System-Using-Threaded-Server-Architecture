package server;

public class AuthService {

    public static boolean authenticate(String user, String pass) {
        return user.equals("admin") && pass.equals("admin123");
    }
}

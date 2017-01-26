

public class User {
    int id;
    String name;
    String login;
    String password;
    String salt;

    public User(int id, String name, String login, String password) {

        this.id = id;
        this.name = name;
        this.login = login;
        this.salt = Security.Salt();
        this.password = Security.MD5(password + Security.MD5(this.salt));

    }
}
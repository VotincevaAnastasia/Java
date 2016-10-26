

public class User {
    int id;
    String name, login, password, Salt;

    public User(int id, String name, String login, String password) {

        this.id = id;
        this.name = name;
        this.login = login;
        Salt = Security.Salt();
        this.password = password;
        //this.password=Security.MD5(Security.MD5(password) + Salt);

    }


}
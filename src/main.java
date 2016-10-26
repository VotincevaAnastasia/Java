import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(0, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(1, "Jane Row", "jrow", "Qweqrty12"));

        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new Role(1, users.get(0), "Read", "a"));
        roles.add(new Role(1, users.get(0), "Write", "a.b"));
        roles.add(new Role(1, users.get(1), "Execute", "a.b.c"));
        roles.add(new Role(1, users.get(0), "Execute", "a.bc"));


        for (int i = 0; i < users.size(); i++) {
            User g = users.get(i);
            if (g.login.equals(args[0])) {
                System.out.println("login OK");
                if (g.password.equals(args[1])) {
                    System.out.println("login+password OK");
                    //System.exit(0);
                } else {
                    System.out.println("password fatal");
                    //System.exit(1);
                }
            } else {
                System.out.println("login fatal");
                //System.exit(2);
            }
        }

    }


}


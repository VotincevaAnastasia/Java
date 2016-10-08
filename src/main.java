import java.util.ArrayList;

public class main {

    public static void main(String[] args) {
//int a = 11; 
// System.out.println("a=" + args[1]); 
//if (a < 12) a++; 
//else System.out.println("a=" + a); 

//User A=new User(1,"NAstya","flkffk","123456"); 

//Role R=new Role(2, A, "WRITE", "a"); 

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(1, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(2, "Jane Row", "jrow", "Qweqrty12"));

        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new Role(1, users.get(0), "Read", "a"));
        roles.add(new Role(1, users.get(0), "Write", "a.b"));
        roles.add(new Role(1, users.get(1), "Execute", "a.b.c"));
        roles.add(new Role(1, users.get(0), "Execute", "a.bc"));
//for(User g:users){ 


// } 
        for (int i = 0; i < users.size(); i++) {
            User g = users.get(i);
            if (g.login == args[0]) {
                if (g.password == args[1]) {
                    System.exit(0);
                } else System.exit(1);
            } else System.exit(2);


        }
    }


}
/**
 * Created by Andrew on 01.10.2016.
 * <p/>
 * Created by Andrew on 01.10.2016.
 * <p/>
 * Created by Andrew on 01.10.2016.
 */

/**
 * Created by Andrew on 01.10.2016.
 */

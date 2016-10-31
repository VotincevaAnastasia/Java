import org.apache.commons.cli.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParseException {
        UserInput userInput = getUserInput(args);


        //*******************************************

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(0, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(1, "Jane Row", "jrow", "Qweqrty12"));

        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new Role(1, users.get(0), "Read", "a"));
        roles.add(new Role(1, users.get(0), "Write", "a.b"));
        roles.add(new Role(1, users.get(1), "Execute", "a.b.c"));
        roles.add(new Role(1, users.get(0), "Execute", "a.bc"));

        int flag = 100;
        for (int i = 0; i < users.size(); i++) {
            User g = users.get(i);
            if (g.login.equals(args[0])) {
                System.out.println("login OK");

                if (g.password.equals(args[1])) {
                    System.out.println("login+password OK");
                    flag = 0;
                    break;
                    //System.exit(0);
                } else {
                    System.out.println("password fatal");
                    flag = 2;
                    //System.exit(1);
                }
            } else {
                System.out.println("login fatal");
                flag = 1;
                //System.exit(2);
            }
        }
        if (flag == 0) System.exit(0);
        if (flag == 1) System.exit(1);
        if (flag == 2) System.exit(2);
    }

    private static UserInput getUserInput(String[] args) throws ParseException {
        // create Options object
        Options options = new Options();

// add t option
        options.addOption("h", false, "help");
        options.addOption("login", true, "login name");
        options.addOption("password", true, "user password ");
        options.addOption("role", true, "role r w e");
        options.addOption("res", true, "resource a.b.c");
        options.addOption("ds", true, "start_date YYYY.MM.DD");
        options.addOption("de", true, "end_date YYYY.MM.DD");
        options.addOption("vol", true, "volume");


        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        UserInput userInput = new UserInput();

        userInput.help = cmd.hasOption("h");
        userInput.login = cmd.getOptionValue("login");
        userInput.password = cmd.getOptionValue("password");
        userInput.role = cmd.getOptionValue("role");
        userInput.resource = cmd.getOptionValue("res");
        userInput.dateStart = cmd.getOptionValue("ds");
        userInput.dateEnd = cmd.getOptionValue("de");
        userInput.volume = cmd.getOptionValue("vol");

        return userInput;
    }


}


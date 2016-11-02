import org.apache.commons.cli.*;

import java.util.ArrayList;

public class Main {
    private static CommandLineParser parser = new DefaultParser();
    private static Options options = new Options();


    public static void main(String[] args) throws ParseException {
        UserInput userInput = getUserInput(args);
        //*******************************************

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(0, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(1, "Jane Row", "jrow", "Qweqrty12"));

        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new Role(0, users.get(0), "Read", "a"));
        roles.add(new Role(1, users.get(0), "Write", "a.b"));
        roles.add(new Role(2, users.get(1), "Execute", "a.b.c"));
        roles.add(new Role(3, users.get(0), "Execute", "a.bc"));

        int flag = 100;

        if (userInput.isAuthorization()) {

            for (int i = 0; i < users.size(); i++) {
                User g = users.get(i);

                if (g.login.equals(userInput.login)) {
                    System.out.println("login OK");

                    if (g.password.equals(userInput.password)) {
                        System.out.println("login+password OK");
                        //flag = 0;
                        //break;
                        //System.exit(0);
                        for (int j = 0; j < roles.size(); j++) {
                            Role r = roles.get(j);
                            if (r.name.equals(userInput.role)) {
                                System.out.println("role OK");

                                if (r.resourse.equals(userInput.resource)) {
                                    System.out.println("ALL OK");
                                    flag = 0;
                                    System.exit(flag);
                                    break;

                                } else {
                                    System.out.println("resource fatal");
                                    flag = 4;
                                    //System.exit(flag);
                                    break;
                                }

                            } else {
                                System.out.println("role fatal");
                                flag = 3;


                            }


                        }
                        System.exit(flag);
                    } else {
                        System.out.println("password fatal");
                        flag = 2;
                        break;

                    }
                } else {

                    System.out.println("login fatal");
                    flag = 1;

                }
            }
            System.exit(flag);


        } else if (userInput.isAccaunting()) {

        } else {
            if (userInput.isAuthentification()) {
                for (int i = 0; i < users.size(); i++) {
                    User g = users.get(i);

                    if (g.login.equals(userInput.login)) {
                        System.out.println("login OK");

                        if (g.password.equals(userInput.password)) {
                            System.out.println("login+password OK");
                            flag = 0;
                            break;

                        } else {
                            System.out.println("password fatal");
                            flag = 2;
                            break;

                        }
                    } else {

                        System.out.println("login fatal");
                        flag = 1;

                    }
                }
                System.exit(flag);

            }
            //new HelpFormatter().printHelp("spravka", options);
            //throw new IllegalStateException("Программа не может находиться в данном состоянии");
        }
    }

    private static UserInput getUserInput(String[] args) throws ParseException {
        // create Options object


// add t option
        options.addOption("h", false, "help");
        options.addOption("login", true, "login name");
        options.addOption("pass", true, "user password ");
        options.addOption("role", true, "role r w e");
        options.addOption("res", true, "resource a.b.c");
        options.addOption("ds", true, "start_date YYYY.MM.DD");
        options.addOption("de", true, "end_date YYYY.MM.DD");
        options.addOption("vol", true, "volume");


        CommandLine cmd = parser.parse(options, args);

        UserInput userInput = new UserInput();

        userInput.help = cmd.hasOption("h");
        userInput.login = cmd.getOptionValue("login");
        userInput.password = cmd.getOptionValue("pass");
        userInput.role = cmd.getOptionValue("role");
        userInput.resource = cmd.getOptionValue("res");
        userInput.dateStart = cmd.getOptionValue("ds");
        userInput.dateEnd = cmd.getOptionValue("de");
        userInput.volume = cmd.getOptionValue("vol");

        return userInput;
    }


}


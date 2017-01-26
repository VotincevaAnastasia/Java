import org.apache.commons.cli.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    private static CommandLineParser parser = new DefaultParser();
    private static Options options = new Options();


    public static void main(String[] args) throws ParseException {


        UserInput userInput = getUserInput(args);

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(0, "John Doe", "jdoe", "sup3rpaZZ"));
        users.add(new User(1, "Jane Row", "jrow", "Qweqrty12"));

        ArrayList<Role> roles = new ArrayList<Role>();
        roles.add(new Role(0, users.get(0), "Read", "a"));
        roles.add(new Role(1, users.get(0), "Write", "a.b"));
        roles.add(new Role(2, users.get(1), "Execute", "a.b.c"));
        roles.add(new Role(3, users.get(0), "Execute", "a.bc"));

        int flag = 100;

        if (userInput.isAccaunting()) {
            System.out.println("isAccaunting");


            for (int i = 0; i < users.size(); i++) {
                User g = users.get(i);

                if (g.login.equals(userInput.login)) {
                    System.out.println("login OK");

                    if (g.password.equals(userInput.password)) {
                        System.out.println("login+password OK");
                        for (int j = 0; j < roles.size(); j++) {
                            Role r = roles.get(j);
                            //TODO Исправить!!!!!
                            if (r.name.equalsIgnoreCase(userInput.role)) {
                                System.out.println("role OK");

                                if (isDivide(r.resourse, userInput.resource)) {
                                    System.out.println("ALL OK");
                                    flag = 0;
                                    ArrayList<Accounting> dates = new ArrayList<>();
                                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                                    simpleDateFormat.setLenient(false);
                                    Date ds = null;
                                    try {
                                        ds = simpleDateFormat.parse(userInput.dateStart);
                                    } catch (java.text.ParseException e) {
                                        System.exit(5);
                                    }
                                    Date de = null;
                                    try {
                                        de = simpleDateFormat.parse(userInput.dateEnd);
                                    } catch (java.text.ParseException e) {
                                        System.exit(5);
                                    }
                                    Integer vol = null;
                                    try {
                                        vol = Integer.valueOf(userInput.volume);
                                    } catch (NumberFormatException e) {
                                        System.exit(5);
                                    }


                                    dates.add(new Accounting(0, r, vol, ds, de));
                                    System.exit(0);


                                } else {
                                    System.out.println("resource fatal");
                                    flag = 4;
                                    System.exit(flag);
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


        }


        if (userInput.isAuthorization()) {
            System.out.println("isAuthorization");

            for (int i = 0; i < users.size(); i++) {
                User g = users.get(i);

                if (g.login.equals(userInput.login)) {
                    System.out.println("login OK");

                    if (g.password.equals(userInput.password)) {
                        System.out.println("login+password OK");
                        for (int j = 0; j < roles.size(); j++) {
                            Role r = roles.get(j);
                            if (r.name.equals(userInput.role)) {
                                System.out.println("role OK");

                                if (isDivide(r.resourse, userInput.resource)) {
                                    System.out.println("ALL OK");
                                    flag = 0;
                                    System.exit(flag);
                                    break;

                                } else {
                                    System.out.println("resource fatal");
                                    flag = 4;
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


        } else {
            if (userInput.isAuthentification()) {
                System.out.println("isAuthentification");
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
        }

    }

    private static boolean isDivide(String resource, String res) {
        String[] dividedRes = resource.split("\\.");
        String[] dividedInp = res.split("\\.");

        if (dividedRes.length > dividedInp.length) {
            return false;
        } else {
            for (int i = 0; i < dividedRes.length; i++) {
                if (!dividedInp[i].equals(dividedRes[i])) {
                    return false;
                }
            }
        }
        return true;

    }

    private static UserInput getUserInput(String[] args) throws ParseException {


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


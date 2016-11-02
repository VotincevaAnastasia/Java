/**
 * Created by student on 31.10.2016.
 */
public class UserInput {


    boolean help;
    String login;
    String password;
    String role;
    String resource;
    String dateStart;
    String dateEnd;
    String volume;


    boolean isAuthentification() {
        return this.login != null && this.password != null;
    }

    boolean isAuthorization() {
        return isAuthentification() && this.role != null && this.resource != null;
        //return this.login != null && this.password != null && this.role != null && this.resource != null;
    }

    boolean isAccaunting() {
        return isAuthorization() && this.dateStart != null && this.dateEnd != null && this.volume != null;
    }

    boolean isEmpty() {
        return !isAccaunting() && !isAuthentification() && !isAuthorization();

    }
}

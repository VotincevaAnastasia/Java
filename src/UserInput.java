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
    }

    boolean isAccaunting() {
        return isAuthorization() && this.dateStart != null && this.dateEnd != null && this.volume != null;
    }

    boolean isEmpty() {
        return !isAccaunting() && !isAuthentification() && !isAuthorization();

    }
}

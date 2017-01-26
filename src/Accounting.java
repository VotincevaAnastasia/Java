
import java.util.Date;

public class Accounting {
    public int id;
    public int amount;
    public Role role;
    public Date date_start;
    public Date date_end;


    public Accounting(int id, Role role, int amount, Date date_start, Date date_end) {
        this.id = id;
        this.role = role;
        this.amount = amount;
        this.date_start = date_start;

    }

}

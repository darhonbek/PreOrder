package BusinessLogic;

/**
 * Created by darho_000 on 12/14/2016.
 */
public class Account {
    protected final String name;
    protected final String surname;
    protected final int ID;
    protected String password;

    public boolean login(String password)
    {
        return (this.password == password);
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getID() {
        return ID;
    }

    public Account(String name, String surname, int ID)
    {
        this.name = name;
        this.surname = surname;
        this.ID = ID;
    }
}

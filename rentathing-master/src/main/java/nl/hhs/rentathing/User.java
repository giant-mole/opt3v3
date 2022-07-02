package nl.hhs.rentathing;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class User implements IDatabase {
    public String id;
    public String email;
    public String password;

    public User() {
    }

    public static User verifyUser(String email, String password) throws FileNotFoundException {
        ArrayList<User> usersdb = IDatabase.getDb(new User(), "usersdb");
        User user = null;
        for (User u :
                usersdb) {
            if (u.email.equals(email) && u.password.equals(password)) {
                user = u;
            }

        }
        return user;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
}

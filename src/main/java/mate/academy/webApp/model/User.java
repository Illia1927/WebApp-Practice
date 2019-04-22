package mate.academy.webApp.model;

import mate.academy.webApp.exeption.NoSuchUserExeption;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String password;
    private static List<User> storage = new ArrayList<>();

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void addUser(User user) {
        storage.add(user);
    }

    public static User getUser(User user) {
        for (int i = 0; i < storage.size(); i++) {
            if (user.equals(storage.get(i))) {
                return storage.get(i);
            }
        }
        throw new NoSuchUserExeption();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public static List<User> getUsers() {
        return storage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        return getPassword() != null ? getPassword().equals(user.getPassword()) : user.getPassword() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        return result;
    }
}

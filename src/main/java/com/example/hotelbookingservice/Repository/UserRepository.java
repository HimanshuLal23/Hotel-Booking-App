package Repository;


import Model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {

    private static List<User> userList;

    private UserRepository() {
        userList = new ArrayList<>();
    }

    private static class Holder {
        private static UserRepository userRepository = new UserRepository();
    }

    public static UserRepository getInstance() {
        return Holder.userRepository;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public static List<User> getUserList() {
        return userList;
    }
}

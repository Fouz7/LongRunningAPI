package x.longrunningapi.services;

import org.springframework.stereotype.Service;
import x.longrunningapi.interfaces.UserGeneratorInterface;
import x.longrunningapi.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserGenerator implements UserGeneratorInterface {

    private static final AtomicLong counter = new AtomicLong();

    public List<User> generateUsers(){
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(counter.incrementAndGet());
            user.setName("User " + i);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> getUsers() {
        return generateUsers();
    }
}

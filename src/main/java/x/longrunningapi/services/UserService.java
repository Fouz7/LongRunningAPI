package x.longrunningapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import x.longrunningapi.models.User;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Service
public class UserService {

    @Autowired
    private UserGenerator userGenerator;


    @Async
    public CompletableFuture<List<User>> getUsers() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return CompletableFuture.completedFuture(null);
        }

        List<User> users = userGenerator.generateUsers();
        return CompletableFuture.completedFuture(users);
    }
}

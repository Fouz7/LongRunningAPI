package x.longrunningapi.interfaces;

import x.longrunningapi.models.User;

import java.util.List;

public interface UserGeneratorInterface {
    List<User> getUsers();
}

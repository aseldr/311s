package springboot.springbootdemo.service;

import springboot.springbootdemo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    void save(User user);
    Optional<User> getById(Long id);
    void delete(Long id);
}
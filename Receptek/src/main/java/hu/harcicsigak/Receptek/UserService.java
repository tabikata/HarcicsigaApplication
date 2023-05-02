package hu.harcicsigak.Receptek;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // CREATE or UPDATE a User
    public User save(User user) {
        return userRepository.save(user);
    }

    // READ a User by ID
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    // READ all Users
    public List<User> findAll() {
        return userRepository.findAll();
    }

    // DELETE a User by ID
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}

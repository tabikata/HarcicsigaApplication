package hu.haricsigak.csigareceptek.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUser(String name) {
        return userRepository.findByName(name);
    }

    public boolean deleteUser(Long id) {
        if (userRepository.findById(id).isEmpty()) return false;
        userRepository.deleteById(id);
        return true;
    }

    public boolean addUser(String name, String password) {
        if (getUser(name).isEmpty()) {
            userRepository.save(new User(name, password));
            return true;
        }
        return false;
    }

    @Transactional
    public void updateUser(Long id, String name, String password) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find user"));

        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)) {
            user.setName(name);
        }

        if (password != null && password.length() > 0) {
            user.setPassword(password);
        }

    }

}

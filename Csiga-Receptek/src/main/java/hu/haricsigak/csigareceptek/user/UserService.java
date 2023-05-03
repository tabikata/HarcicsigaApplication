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
        return this.userRepository.findAll();
    }

    public Optional<User> getUser(Long id) {
        return this.userRepository.findById(id);
    }

    public Optional<User> getUser(String username) {
        return this.userRepository.findByUsername(username);
    }

    public boolean deleteUser(Long id) {
        if (this.userRepository.findById(id).isEmpty()) return false;
        this.userRepository.deleteById(id);
        return true;
    }

    public boolean addUser(String username, String password) {
        if (getUser(username).isEmpty()) {
            userRepository.save(new User(username, password));
            return true;
        }
        return false;
    }

    @Transactional
    public void updateUser(Long id, String username, String password) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Unable to find user"));
        if (username != null && username.length() > 0 && !Objects.equals(user.getUsername(), username)) {
            user.setUsername(username);
        }
        if (password != null && password.length() > 0) user.setPassword(password);
    }

}

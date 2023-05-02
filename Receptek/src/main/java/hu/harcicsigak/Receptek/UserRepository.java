package hu.harcicsigak.Receptek;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    // CREATE or UPDATE a User
    User save(User user);

    // READ a User by ID
    Optional<User> findById(Long id);

    // READ all Users
    List<User> findAll();

    // READ all Users by IDs
    List<User> findAllById(Iterable<Long> ids);

    // DELETE a User by ID
    void deleteById(Long id);

    // DELETE a User
    void delete(User user);

    // DELETE all Users
    void deleteAll();

}


package hu.haricsigak.csigareceptek.user;

import jakarta.persistence.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

    public User() {

    }

    public User(Long id, String username, String password) {
        this(username, password);
        this.id = id;
    }

    public User(String username, String password) {
        this.name = username;
        this.password = this.hash(password);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String username) {
        this.name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = this.hash(password);
    }

    private String hash(String plaintext) {
        return new BCryptPasswordEncoder(10, new SecureRandom()).encode(plaintext);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + this.id +
                ", username='" + this.name + '\'' +
                ", password='" + this.password + '\'' +
                '}';
    }
}

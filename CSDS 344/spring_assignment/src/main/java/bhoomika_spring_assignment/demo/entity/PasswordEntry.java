package bhoomika_spring_assignment.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "passwords")
public class PasswordEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getId() { return id; }

    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
}
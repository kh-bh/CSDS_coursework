package bhoomika_spring_assignment.demo.repository;

import bhoomika_spring_assignment.demo.entity.PasswordEntry;
import bhoomika_spring_assignment.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasswordRepository extends JpaRepository<PasswordEntry, Long> {
    List<PasswordEntry> findByUser(User user);
}
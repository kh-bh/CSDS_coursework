package bhoomika_spring_assignment.demo.controller;

import bhoomika_spring_assignment.demo.entity.PasswordEntry;
import bhoomika_spring_assignment.demo.entity.User;
import bhoomika_spring_assignment.demo.repository.PasswordRepository;
import bhoomika_spring_assignment.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/passwords")
public class PasswordController {

    @Autowired
    private PasswordRepository passwordRepo;

    @Autowired
    private UserRepository userRepo;

    private String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @PostMapping
    public ResponseEntity<Void> savePassword(@RequestBody PasswordEntry entry) {

        String username = getUsername();
        User user = userRepo.findByUsername(username).orElseThrow();

        entry.setUser(user);
        passwordRepo.save(entry);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Map<String, String>> getPasswords() {

        String username = getUsername();
        User user = userRepo.findByUsername(username).orElseThrow();

        List<PasswordEntry> entries = passwordRepo.findByUser(user);

        List<Map<String, String>> result = new ArrayList<>();

        for (PasswordEntry p : entries) {
            Map<String, String> map = new HashMap<>();
            map.put("label", p.getLabel());
            map.put("password", p.getPassword());
            result.add(map);
        }

        return result;
    }
}
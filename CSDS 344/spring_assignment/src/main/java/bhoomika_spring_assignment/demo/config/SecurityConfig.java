package bhoomika_spring_assignment.demo.config;

import bhoomika_spring_assignment.demo.entity.User;
import bhoomika_spring_assignment.demo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final UserRepository userRepository;

    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> {
            user = userRepository.findByUsername(username);
            if (user == null) throw new UsernameNotFoundException("User not Found: " + username);
            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(User.getPassword())
                    .build();
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().permitAll()
                );

        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }

}
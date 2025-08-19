package com.example.PersonalExpense.service;

import com.example.PersonalExpense.model.User;
import com.example.PersonalExpense.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DatabaseMigrationService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void migratePasswords() {
        userRepository.findAll().forEach(user -> {
            String password = user.getPassword();
            if (password != null && !password.startsWith("$2a$") && !password.startsWith("$2b$") && !password.startsWith("$2y$")) {
                user.setPassword(bCryptPasswordEncoder.encode(password));
                userRepository.save(user);
                System.out.println("Updated password for user: " + user.getUsername());
            }
        });
    }
    @Bean
    public CommandLineRunner runMigration(DatabaseMigrationService migrationService) {
        return args -> migrationService.migratePasswords();
    }
}
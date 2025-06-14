package com.wbs.springboot_nelio_alves.config;

import com.wbs.springboot_nelio_alves.entities.User;
import com.wbs.springboot_nelio_alves.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        var user1 = new User(null, "William", "william@gmail.com", "79 999999999", "123456");
        var user2 = new User(null, "Bob", "bob@gmail.com", "55 888888888", "123456");

        userRepository.saveAll(Arrays.asList(user1, user2));
    }
}

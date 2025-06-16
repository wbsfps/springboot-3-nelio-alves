package com.wbs.springboot_nelio_alves.config;

import com.wbs.springboot_nelio_alves.entities.Category;
import com.wbs.springboot_nelio_alves.entities.Order;
import com.wbs.springboot_nelio_alves.entities.User;
import com.wbs.springboot_nelio_alves.entities.enums.OrderStatus;
import com.wbs.springboot_nelio_alves.repository.CategoryRepository;
import com.wbs.springboot_nelio_alves.repository.OrderRepository;
import com.wbs.springboot_nelio_alves.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        var user1 = new User(null, "William", "william@gmail.com", "79 999999999", "123456");
        var user2 = new User(null, "Bob", "bob@gmail.com", "55 888888888", "123456");

        var order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        var order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        var order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);

        var category1 = new Category(null, "Electronics");
        var category2 = new Category(null, "Books");

        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2));
    }
}

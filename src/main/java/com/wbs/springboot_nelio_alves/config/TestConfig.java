package com.wbs.springboot_nelio_alves.config;

import com.wbs.springboot_nelio_alves.entities.*;
import com.wbs.springboot_nelio_alves.entities.enums.OrderStatus;
import com.wbs.springboot_nelio_alves.repository.*;
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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        var user1 = new User(null, "William", "william@gmail.com", "79 999999999", "123456");
        var user2 = new User(null, "Bob", "bob@gmail.com", "55 888888888", "123456");

        var order1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, user1);
        var order2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, user2);
        var order3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, user1);

        var category1 = new Category(null, "Electronics");
        var category2 = new Category(null, "Books");
        var category3 = new Category(null, "Computers");

        var p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        var p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        var p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        var p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        var p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");


        userRepository.saveAll(Arrays.asList(user1, user2));
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));
        categoryRepository.saveAll(Arrays.asList(category1, category2));
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        p1.getCategories().add(category2);
        p2.getCategories().add(category1);
        p2.getCategories().add(category3);
        p3.getCategories().add(category3);
        p4.getCategories().add(category3);
        p5.getCategories().add(category2);

        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        var orderItem1 = new OrderItem(order1, p1, 2, p1.getPrice());
        var orderItem2 = new OrderItem(order1, p3, 1, p4.getPrice());
        var orderItem3 = new OrderItem(order2, p3, 2, p1.getPrice());
        var orderItem4 = new OrderItem(order3, p5, 2, p5.getPrice());

        orderItemRepository.saveAll(Arrays.asList(orderItem1, orderItem2, orderItem3, orderItem4));

        var payment = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"), order1);
        order1.setPayment(payment);
        orderRepository.save(order1);
    }
}

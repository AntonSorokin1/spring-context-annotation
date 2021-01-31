package org.shop.configuration;

import org.shop.repository.*;
import org.shop.repository.factory.UserRepositoryFactory;
import org.shop.repository.map.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class RepositoryConfiguration {
    @Bean
    public ItemRepository itemRepository() {
        return new ItemMapRepository();
    }

    @Bean
    public OrderRepository orderRepository() throws IOException {
        Properties properties = new Properties();
        InputStream stream = RepositoryConfiguration.class.getClassLoader().getResourceAsStream("some.properties");
        properties.load(stream);
        long initialSequence = Long.parseLong((String) properties.get("order_repository_initial_sequence"));
        OrderMapRepository repository = new OrderMapRepository();
        repository.setSequence(initialSequence);
        return repository;
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductMapRepository();
    }

    @Bean
    public ProposalRepository proposalRepository() {
        return new ProposalMapRepository();
    }

    @Bean
    public SellerRepository sellerRepository() {
        return new SellerMapRepository();
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepositoryFactory().createUserRepository();
    }
}

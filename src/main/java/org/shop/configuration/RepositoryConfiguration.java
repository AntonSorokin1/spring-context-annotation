package org.shop.configuration;

import org.shop.repository.*;
import org.shop.repository.factory.UserRepositoryFactory;
import org.shop.repository.map.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:some.properties")
public class RepositoryConfiguration {
    @Bean
    public ItemRepository itemRepository() {
        return new ItemMapRepository();
    }

    @Bean
    @Value("${order_repository_initial_sequence}")
    public OrderRepository orderRepository(long initialSequence) {
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

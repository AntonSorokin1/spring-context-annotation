package org.shop.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        RepositoryConfiguration.class,
        ServicesConfiguration.class,
        DataInitializerConfiguration.class
})
public class MainConfiguration {
}

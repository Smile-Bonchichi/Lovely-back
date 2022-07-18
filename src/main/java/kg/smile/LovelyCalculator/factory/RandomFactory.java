package kg.smile.LovelyCalculator.factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class RandomFactory {
    @Bean
    public Random getRandomBean() {
        return new Random();
    }
}

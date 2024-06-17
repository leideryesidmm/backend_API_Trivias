package com.gamegenius.trivia.context;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DotenvConfig {

    private final ConfigurableEnvironment env;
    private Dotenv dotenv;

    public DotenvConfig(ConfigurableEnvironment env) {
        this.env = env;
    }

    @PostConstruct
    public void initializeDotenv() {
        this.dotenv = Dotenv.configure().ignoreIfMissing().load();
        setUpEnv();
    }

    private void setUpEnv() {
        Map<String, Object> dotenvMap = new HashMap<>();
        dotenv.entries().forEach(entry -> dotenvMap.put(entry.getKey(), entry.getValue()));

        env.getPropertySources().addFirst(new MapPropertySource("dotenvProperties", dotenvMap));
    }

    @Bean
    public Dotenv dotenv() {
        return dotenv;
    }
}

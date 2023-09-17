package com.sgcib.vault;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.vault.config.VaultConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("!test")
public class CustomVaultConfiguration {

    @Value("#{'${spring.cloud.vault.secret-paths'}.split(',')}")
    private List<String> secretPaths;

    @Value("#{'${spring.cloud.vault.kv.backend'}")
    private String backend;

    @Bean
    public VaultConfigurer configurer() {
        return configurer -> {
            secretPaths.forEach(secretPath -> configurer.add(String.format("%s%s", backend, secretPath)));
            configurer.registerDefaultKeyValueSecretBackends(false);
            configurer.registerDefaultDiscoveredSecretBackends(false);
        };
    }
}

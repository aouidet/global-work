package com.sgcib.vault;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.cloud.vault.config.VaultConfigurer;

public class CustomVaultConfigurationTest {

    private final ApplicationContextRunner contextRunner = new ApplicationContextRunner()
            .withUserConfiguration(CustomVaultConfiguration.class);

    @Test
    public void should_check_presence_of_vault_configurer_bean() {
        contextRunner.run(context -> Assertions.assertThat(context).hasSingleBean(VaultConfigurer.class));
    }
}

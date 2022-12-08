package ua.kovalchuk.springstarterbean;

import java.util.Collections;
import java.util.List;
import org.springframework.boot.autoconfigure.AutoConfigurationPackages;
import org.springframework.boot.jackson.JsonMixinModule;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

    /**
     * why ovveride not work without @ConditionalOnMissingBean
     * https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.developing-auto-configuration
     * @Primary not works
     * bean from autoconfiguration {@link org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration}
     */
    @Bean
    @Primary
    public JsonMixinModule jsonMixinModule(ApplicationContext context) {
        List<String> packages = AutoConfigurationPackages.has(context) ? AutoConfigurationPackages.get(context)
            : Collections.emptyList();
        return new JsonMixinModule(context, packages);
    }
}

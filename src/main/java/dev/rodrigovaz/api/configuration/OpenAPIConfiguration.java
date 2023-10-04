package dev.rodrigovaz.api.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {
    @Bean
    OpenAPI getConfigurationOpenApi() {
        return new OpenAPI().info(new Info().title("Cadastro de usuarios")
                .description("API Rest para cadastro de um usuario e senha")
                .version("0.0.1")
                .license(new License().name("GPL 3.0").url("https://www.gnu.org/licenses/gpl-3.0.html")))
                .externalDocs(new ExternalDocumentation().description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }
}

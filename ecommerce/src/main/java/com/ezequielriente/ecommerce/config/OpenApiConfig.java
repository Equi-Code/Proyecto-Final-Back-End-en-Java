package com.ezequielriente.ecommerce.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI ecommerceOpenAPI() {

        return new OpenAPI()

                .info(new Info()

                        .title("Ecommerce API")

                        .description("""
                                API REST desarrollada con Spring Boot
                                
                                Proyecto portfolio de Ezequiel Riente.
                                
                                Permite administrar productos deportivos,
                                accesorios e indumentaria.
                                """)

                        .version("1.0.0")

                        .contact(new Contact()

                                .name("Ezequiel Riente")

                                .email("tu-email@gmail.com")

                                .url("https://github.com/TU_GITHUB"))

                        .license(new License()

                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")))

                .externalDocs(new ExternalDocumentation()

                        .description("Repositorio del proyecto")
                        .url("https://github.com/TU_GITHUB"));
    }

}
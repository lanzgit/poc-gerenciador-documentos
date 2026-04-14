package br.edu.infnet.gerenciador_documentos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Gerenciador de Documentos API")
                        .description("API REST para gerenciamento de documentos oficiais (Ofícios e Informes)")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Instituto Infnet")
                                .email("contato@infnet.edu.br")));
    }
}

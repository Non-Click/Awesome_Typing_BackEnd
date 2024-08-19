package com.awesome.typing1.global.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI awesomeAPI() {
        Info info = new Info().title("awsome typing API").description("awsome typing API 명세").version("0.0.1");

        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .info(info);
    }
}

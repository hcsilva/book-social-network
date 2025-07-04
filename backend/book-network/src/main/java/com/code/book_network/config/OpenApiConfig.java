package com.code.book_network.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(contact = @Contact(name = "Henrique", email = "henrique@code.com.br", url = "henriquecode.com.br")
                , description = "OpenApi documentation for Spring Security"
                , title = "OpenApi specification - Henrique"
                , version = "1.0",
                license = @License(name = "License name", url = "some-url"),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(description = "Local ENV", url = "http://localhost:8088/api/v1"),
                @Server(description = "Local PROD", url = "http://1.1.13:8088/api/v1")
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth"
                )
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}

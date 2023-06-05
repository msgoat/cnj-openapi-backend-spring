package group.msg.at.cloud.cloudtrain.adapter.rest;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringDoc supports programmatic definition of global OpenAPI headers.
 */
@Configuration
public class OpenApiConfiguration {

    @Value("${openapi.contact.url}")
    String contactUrl;

    @Value("${openapi.servers.default.url}")
    String defaultServerUrl;

    @Value("${openapi.info.title}")
    String title;

    @Value("${openapi.info.version}")
    String version;

    @Value("${openapi.components.securitySchemes.oidc.openIdConnectUrl}")
    String openIdConnectUrl;

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info().title(title).version(version).contact(new Contact().url(contactUrl)))
                .addServersItem(new Server().url(defaultServerUrl))
                .components(new Components()
                        .addSecuritySchemes("oidc",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.OPENIDCONNECT)
                                        .openIdConnectUrl("https://oidc.cloudtrain.aws.msgoat.eu/realms/cloudtrain/.well-known/openid-configuration")));
    }
}

package group.msg.at.cloud.cloudtrain.adapter.rest.grantedpermissions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

/**
 * Configuration bean which provides an HTTP service proxy for the annotated HTTP interface {@code GrantedPermissionsClient}.
 */
@Configuration
public class GrantedPermissionsClientConfiguration {

    @Bean
    GrantedPermissionsClient grantedPermissionsClient(
            WebClient.Builder webClientBuilder,
            @Value("${cloudtrain.services.downstream.url}") String downstreamUrl
    ) {
        WebClient webClient = webClientBuilder.baseUrl(downstreamUrl).build();
        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
        return proxyFactory.createClient(GrantedPermissionsClient.class);
    }

}

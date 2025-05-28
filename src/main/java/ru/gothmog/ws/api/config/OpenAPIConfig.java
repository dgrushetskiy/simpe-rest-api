package ru.gothmog.ws.api.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@OpenAPIDefinition(info = @Info(title = "simple-rest-api API Service", description = "МКС Сервис для работы с продуктом", version = "1.0.0"))
public class OpenAPIConfig {

    private static final String SLASH = "/";
    private static final String SLASH_SERVER_NAME = SLASH + "simple-rest-api";
    private static final String API_GATE_WEY = SLASH + "api-gateway" + SLASH_SERVER_NAME;

    @Value("${app.openapi.local-url}")
    private String localUrl;

    @Value("${app.openapi.develop-url}")
    private String devUrl;

    @Value("${app.openapi.ift-url}")
    private String iftUrl;

    @Profile("local")
    @Bean
    public OpenAPI openAPILocal(ServletContext servletContext) {
        var openAPI = new OpenAPI();
        addServer(openAPI, localUrl, "Default Server URL");
        addServer(openAPI, devUrl, "DEV Server URL");
        addServer(openAPI, iftUrl, "IFT Server URL");
        return openAPI;
    }

    @Profile("!local")
    @Bean
    public OpenAPI openAPI(ServletContext servletContext) {
        var openAPI = new OpenAPI();
        addServer(openAPI, localUrl, "Default Server URL");
        addServer(openAPI, devUrl + API_GATE_WEY, "DEV Server URL");
        addServer(openAPI, iftUrl + API_GATE_WEY, "IFT Server URL");
        return openAPI;
    }

    private void addServer(OpenAPI openAPI, String url, String description) {
        var server = new Server();
        server.setUrl(url);
        server.setDescription(description);
        openAPI.addServersItem(server);
    }
}

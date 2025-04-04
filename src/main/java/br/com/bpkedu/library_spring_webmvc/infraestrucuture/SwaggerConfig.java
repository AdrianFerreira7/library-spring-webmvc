package br.com.bpkedu.library_spring_webmvc.infraestrucuture;


import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean  // Corrigido: adicionado o símbolo @ na anotação Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(apiInfo());
    }

    private io.swagger.v3.oas.models.info.Info apiInfo() {  // Corrigido: usando o caminho completo da classe Info
        return new io.swagger.v3.oas.models.info.Info()
                .title("")
                .version("1.0")
                .description(".")
                .contact(new io.swagger.v3.oas.models.info.Contact()  // Corrigido: usando o caminho completo da classe Contact
                        .name("")
                        .email(""))
                .license(new io.swagger.v3.oas.models.info.License()  // Corrigido: usando o caminho completo da classe License
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0.html"));
    }

}

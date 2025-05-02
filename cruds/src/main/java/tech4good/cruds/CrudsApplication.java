package tech4good.cruds;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "API de Doações - Projeto ASA",
                version = "1.0.0",
                description = "Sistema de gerenciamento de arrecadação e distribuição de cestas básicas para famílias em vulnerabilidade social  \n" +
                        "\nDesign Pattern escolhido: Adapter.\n" +
                        "\nIntegrantes:\n- Bruna Santana Reginato\n- Fernando Felix da Silva" +
                        "\n- Ilys Gomes Maroto\n- Lucas Alves Matos\n- Matheus Yukio Makiyama\n- Vinicius Miralha Augusto Gomes\n\n" +
                        "![Logo do Projeto](https://raw.githubusercontent.com/tech-4good/Documentation/main/logo-tech4good-2.png)" +
                        "![Logo da ASA](https://raw.githubusercontent.com/tech-4good/Documentation/main/logo-asa.png)\n\n",
                contact = @Contact(
                        name = "Equipe do Projeto",
                        email = "PesquisaeInovao-ProjetodeExtenso-Grupo5@sptech.school"
                )
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080",
                        description = "Servidor Local"
                )
        }
)

@SpringBootApplication
public class CrudsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudsApplication.class, args);
        System.out.println("http://localhost:8080/swagger-ui/index.html");
    }

}

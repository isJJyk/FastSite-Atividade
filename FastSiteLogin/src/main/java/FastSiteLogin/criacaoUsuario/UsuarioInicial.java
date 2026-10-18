package FastSiteLogin.criacaoUsuario;

import FastSiteLogin.entities.Usuario;
import FastSiteLogin.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UsuarioInicial {
    @Bean
    CommandLineRunner criarUsuario(UsuarioRepository repository, PasswordEncoder encoder) {
        return args -> {
            if (repository.findByLogin("admin").isEmpty()) {
                repository.save(new Usuario("user", encoder.encode("1234")));
            }
        };
    }
}

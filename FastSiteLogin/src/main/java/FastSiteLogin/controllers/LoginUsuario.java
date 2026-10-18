package FastSiteLogin.controllers;

import FastSiteLogin.entities.Usuario;
import FastSiteLogin.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class LoginUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String paginaLogin(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @PostMapping("/login")
    public String loginUsuario(@ModelAttribute("usuario") Usuario usuario, Model model) {
        Optional<Usuario> usuarioEncontrado = usuarioRepository.findByLogin(usuario.getLogin());

        if (usuarioEncontrado.isPresent()
                && passwordEncoder.matches(usuario.getSenha(), usuarioEncontrado.get().getSenha())) {
            return "redirect:/pagina1";
        }

        model.addAttribute("erro", "Usuário ou Senha incorretos, tente novamente");
        return "login";
    }

    @GetMapping("/pagina1")
    public String paginaHome() {
        return "pagina1";
    }
}
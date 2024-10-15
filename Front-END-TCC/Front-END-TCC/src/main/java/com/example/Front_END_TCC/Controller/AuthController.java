package com.example.Front_END_TCC.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Front_END_TCC.Model.UserEntity;
import com.example.Front_END_TCC.repository.UserRepository;

@Controller
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/login")
    public String login() {
        return "login"; // retorna o template login.html
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserEntity()); // cria um novo objeto UserEntity para o formulário
        return "register"; // retorna o template register.html
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute UserEntity user) {
        userRepository.save(user); // salva o novo usuário no banco de dados
        return "redirect:/login"; // redireciona para a página de login após o registro
    }
}

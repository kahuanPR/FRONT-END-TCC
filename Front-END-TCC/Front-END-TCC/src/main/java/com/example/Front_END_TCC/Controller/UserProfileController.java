package com.example.Front_END_TCC.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.Front_END_TCC.Model.UserProfileEntity;
import com.example.Front_END_TCC.repository.UserProfileRepository;

import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class UserProfileController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @GetMapping("/perfis") // Exibe a lista de perfis
    public String listarPerfis(Model model) {
        List<UserProfileEntity> perfis = userProfileRepository.findAll();
        model.addAttribute("perfis", perfis);
        return "perfis"; // Nome do arquivo HTML
    }

    @GetMapping("/adicionar-perfil") // Exibe o formulário para adicionar perfil
    public String mostrarFormularioAdicionarPerfil(Model model) {
        model.addAttribute("userProfile", new UserProfileEntity()); // Adiciona um novo perfil ao modelo
        return "adicionar-perfil"; // Nome do arquivo HTML para o formulário
    }

    @PostMapping("/adicionar-perfil") // Processa o envio do formulário
    public String adicionarPerfil(@ModelAttribute UserProfileEntity userProfile) {
        userProfileRepository.save(userProfile); // Salva o perfil no banco de dados
        return "redirect:/perfis"; // Redireciona para a lista de perfis
    }
}

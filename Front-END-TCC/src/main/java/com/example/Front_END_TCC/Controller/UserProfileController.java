package com.example.Front_END_TCC.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.Front_END_TCC.Model.Contratacao;
import com.example.Front_END_TCC.Model.UserProfileEntity;
import com.example.Front_END_TCC.repository.UserProfileRepository;
import com.example.Front_END_TCC.repository.ContratacaoRepository;

@Controller
public class UserProfileController {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private ContratacaoRepository contratacaoRepository;

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

    @GetMapping("/perfis/{id}") // Exibe o perfil completo em um card
    public String verPerfilCompleto(@PathVariable Long id, Model model) {
        UserProfileEntity userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Perfil inválido: " + id));
        model.addAttribute("userProfile", userProfile);
        return "perfil-detalhado"; // Nome do arquivo HTML para o card de detalhes
    }

    @PostMapping("/avaliar/{id}")
    public String avaliarPerfil(@PathVariable Long id, @RequestParam("avaliacao") Double avaliacao) {
        UserProfileEntity userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Perfil inválido: " + id));
        userProfile.setAvaliacao(avaliacao); // Atualiza a avaliação
        userProfileRepository.save(userProfile); // Salva a avaliação no banco de dados
        return "redirect:/perfis/" + id; // Redireciona para a página do perfil após avaliar
    }

    @GetMapping("/contratar/{id}")
    public String contratarUsuario(@PathVariable Long id, @RequestParam("clienteId") Long clienteId) {
        UserProfileEntity freelancer = userProfileRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Freelancer inválido: " + id));
        UserProfileEntity cliente = userProfileRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente inválido: " + clienteId));

        Contratacao contratacao = new Contratacao(cliente, freelancer);
        contratacaoRepository.save(contratacao);

        return "redirect:/contratacoes/" + clienteId; // Redireciona para a página de contratações
    }


    @GetMapping("/contratacoes/{clienteId}")
    public String listarContratacoes(@PathVariable Long clienteId, Model model) {
        UserProfileEntity cliente = userProfileRepository.findById(clienteId)
                .orElseThrow(() -> new IllegalArgumentException("Cliente inválido: " + clienteId));
        List<Contratacao> contratacoes = contratacaoRepository.findByCliente(cliente);
        model.addAttribute("contratacoes", contratacoes);
        return "contratacoes"; // Nome do arquivo HTML para exibir contratações
    }

    @GetMapping("/negociar/{id}")
    public String negociarComUsuario(@PathVariable Long id) {
        // Lógica para processar negociação
        return "redirect:/perfis/" + id;
    }

    @GetMapping("/rejeitar/{id}")
    public String rejeitarUsuario(@PathVariable Long id) {
        // Lógica para processar rejeição
        return "redirect:/perfis/" + id;
    }
    
}

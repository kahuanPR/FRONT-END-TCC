package com.example.Front_END_TCC.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_perfis") // Nome da tabela no banco de dados
public class UserProfileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false) // Nome do usuário
    private String nome;

    @Column(name = "descricao_servico") // Descrição do serviço
    private String descricaoServico;

    @Column(name = "avaliacao") // Avaliação do usuário
    private Double avaliacao;

    @Column(name = "localizacao") // Localização do usuário
    private String localizacao;

    @Column(name = "ofertas") // Ofertas de serviço do usuário
    private String ofertas;

    // Construtores, getters e setters
    public UserProfileEntity() {
    }

    public UserProfileEntity(String nome, String descricaoServico, Double avaliacao, String localizacao, String ofertas) {
        this.nome = nome;
        this.descricaoServico = descricaoServico;
        this.avaliacao = avaliacao;
        this.localizacao = localizacao;
        this.ofertas = ofertas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaoServico() {
        return descricaoServico;
    }

    public void setDescricaoServico(String descricaoServico) {
        this.descricaoServico = descricaoServico;
    }

    public Double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getOfertas() {
        return ofertas;
    }

    public void setOfertas(String ofertas) {
        this.ofertas = ofertas;
    }

    @Override
    public String toString() {
        return "UserProfileEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricaoServico='" + descricaoServico + '\'' +
                ", avaliacao=" + avaliacao +
                ", localizacao='" + localizacao + '\'' +
                ", ofertas='" + ofertas + '\'' +
                '}';
    }
}

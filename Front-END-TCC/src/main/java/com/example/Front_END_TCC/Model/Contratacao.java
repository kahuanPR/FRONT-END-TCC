package com.example.Front_END_TCC.Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
	public class Contratacao {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @ManyToOne
	    @JoinColumn(name = "cliente_id", nullable = false)
	    private UserProfileEntity cliente; // Cliente que contrata

	    @ManyToOne
	    @JoinColumn(name = "freelancer_id", nullable = false)
	    private UserProfileEntity freelancer; // Freelancer contratado

	    private LocalDateTime dataContratacao;

	    public Contratacao() {
	        this.dataContratacao = LocalDateTime.now();
	    }

	    public Contratacao(UserProfileEntity cliente, UserProfileEntity freelancer) {
	        this.cliente = cliente;
	        this.freelancer = freelancer;
	        this.dataContratacao = LocalDateTime.now();
	    }

	    // Getters e Setters

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public UserProfileEntity getCliente() {
	        return cliente;
	    }

	    public void setCliente(UserProfileEntity cliente) {
	        this.cliente = cliente;
	    }

	    public UserProfileEntity getFreelancer() {
	        return freelancer;
	    }

	    public void setFreelancer(UserProfileEntity freelancer) {
	        this.freelancer = freelancer;
	    }

	    public LocalDateTime getDataContratacao() {
	        return dataContratacao;
	    }

	    public void setDataContratacao(LocalDateTime dataContratacao) {
	        this.dataContratacao = dataContratacao;
	    }
	}


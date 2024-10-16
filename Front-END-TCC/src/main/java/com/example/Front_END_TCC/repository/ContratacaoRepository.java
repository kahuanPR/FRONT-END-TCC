package com.example.Front_END_TCC.repository;

import com.example.Front_END_TCC.Model.Contratacao;
import com.example.Front_END_TCC.Model.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratacaoRepository extends JpaRepository<Contratacao, Long> {
    List<Contratacao> findByCliente(UserProfileEntity cliente);
}

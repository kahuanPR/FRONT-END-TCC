package com.example.Front_END_TCC.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Front_END_TCC.Model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // Você pode adicionar métodos personalizados aqui, se necessário
}

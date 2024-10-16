package com.example.Front_END_TCC.repository;

import com.example.Front_END_TCC.Model.UserProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfileEntity, Long> {
    // Você pode adicionar métodos de consulta personalizados aqui, se necessário
}

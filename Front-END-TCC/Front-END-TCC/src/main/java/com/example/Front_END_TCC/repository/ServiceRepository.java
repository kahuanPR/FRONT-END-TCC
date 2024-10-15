package com.example.Front_END_TCC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Front_END_TCC.Model.ServiceEntity;

public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {}

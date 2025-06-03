package com.order_online.user_service.adapter.output.repository;

import com.order_online.user_service.adapter.output.persistence.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryJpa extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
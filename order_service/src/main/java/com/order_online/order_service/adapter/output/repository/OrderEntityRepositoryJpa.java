package com.order_online.order_service.adapter.output.repository;

import com.order_online.order_service.adapter.output.persistence.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderEntityRepositoryJpa extends JpaRepository<OrderEntity, Long> {
}

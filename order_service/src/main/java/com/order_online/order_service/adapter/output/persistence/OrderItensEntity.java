package com.order_online.order_service.adapter.output.persistence;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ORDER_ITENS_ENTITY")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItensEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double price;
}

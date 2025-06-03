package com.order_online.order_service.domain.model;

import java.util.List;

public class OrderModel {

    private Long id;

    private List<OrderItensModel> orderItens;

    private Double total;

    private String customerId;

    private String businessId;

    public OrderModel(Long id, List<OrderItensModel> orderItens, Double total, String customerId, String businessId) {
        this.id = id;
        this.orderItens = orderItens;
        this.total = total;
        this.customerId = customerId;
        this.businessId = businessId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItensModel> getOrderItens() {
        return orderItens;
    }

    public void setOrderItens(List<OrderItensModel> orderItens) {
        this.orderItens = orderItens;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }
}

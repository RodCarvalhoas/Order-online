package com.order_online.order_service.infra;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JsonMapper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public String toJson(Object genericModel) {
        try {
            return objectMapper.writeValueAsString(genericModel);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter para JSON", e);
        }
    }

    public <T> T fromJson(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Erro ao converter JSON para objeto", e);
        }
    }
}

package com.order_online.user_service.adapter.utils;

import com.order_online.user_service.adapter.input.transport.user.CreateUserRequest;
import com.order_online.user_service.adapter.output.persistence.UserEntity;
import com.order_online.user_service.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

    UserModel toDomain(UserEntity entity);

    @Mapping(target = "authorities", ignore = true)
    UserEntity toEntity(UserModel model);

    @Mapping(target = "id", ignore = true)
    UserModel toDomain(CreateUserRequest request);
}

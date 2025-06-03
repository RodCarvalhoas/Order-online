package com.order_online.user_service.port.output;

import com.order_online.user_service.domain.model.UserModel;

public interface UserRepositoryPort {

    UserModel saveUser(UserModel user);

    UserModel findByEmail(String email);

    UserModel findById(Long id);
}

package com.order_online.user_service.port.input;

import com.order_online.user_service.domain.model.UserModel;
import com.order_online.user_service.port.transport.CreateUserResult;

public interface UserServicePort {
    CreateUserResult saveUser(UserModel user);

    UserModel findByEmail(String email);
    
    String login(String email, String password);

    void withdrawBalance(String id, Integer balance);
}
package com.order_online.user_service.adapter.output.repository;

import com.order_online.user_service.adapter.output.persistence.UserEntity;
import com.order_online.user_service.adapter.utils.UserMapper;
import com.order_online.user_service.domain.model.UserModel;
import com.order_online.user_service.port.output.UserRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements UserRepositoryPort {

    @Autowired
    private UserRepositoryJpa userRepositoryJpa;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserModel saveUser(UserModel user) {
        UserEntity entity = this.userMapper.toEntity(user);
        UserEntity savedUser = userRepositoryJpa.save(entity);

        return this.userMapper.toDomain(savedUser);
    }

    @Override
    public UserModel findByEmail(String email) {
        return userMapper.toDomain(userRepositoryJpa.findByEmail(email));
    }

    @Override
    public UserModel findById(Long id) {
        return userMapper.toDomain(userRepositoryJpa.findById(id).get());
    }
}

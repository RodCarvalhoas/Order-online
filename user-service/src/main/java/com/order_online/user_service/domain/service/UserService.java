package com.order_online.user_service.domain.service;

import com.order_online.user_service.domain.exception.InvalidBalanceException;
import com.order_online.user_service.domain.exception.InvalidCredentialsException;
import com.order_online.user_service.domain.exception.UserNotFoundException;
import com.order_online.user_service.domain.model.UserModel;
import com.order_online.user_service.port.input.UserServicePort;
import com.order_online.user_service.port.output.PasswordEncoderServicePort;
import com.order_online.user_service.port.output.TokenServicePort;
import com.order_online.user_service.port.output.UserRepositoryPort;
import com.order_online.user_service.port.transport.CreateUserResult;


import java.util.Objects;

public class UserService implements UserServicePort {

    private UserRepositoryPort userRepositoryPort;

    private PasswordEncoderServicePort passwordEncoderServicePort;

    private TokenServicePort tokenServicePort;

    public UserService(UserRepositoryPort userRepositoryPort, PasswordEncoderServicePort passwordEncoderServicePort, TokenServicePort tokenServicePort) {
        this.userRepositoryPort = userRepositoryPort;
        this.passwordEncoderServicePort = passwordEncoderServicePort;
        this.tokenServicePort = tokenServicePort;
    }

    @Override
    public CreateUserResult saveUser(UserModel user) {
        System.out.println(user.getEmail());
        String encryptedPassword = passwordEncoderServicePort.encode(user.getPassword());
        user.setPassword(encryptedPassword);

        UserModel userModel = this.userRepositoryPort.saveUser(user);
        if(Objects.isNull(userModel))
            throw new RuntimeException("Error while register user with email: " + userModel.getEmail());

        System.out.println(userModel.getEmail());
        String token = tokenServicePort.generateToken(userModel);

        return new CreateUserResult(userModel.getId(), token);
    }

    @Override
    public UserModel findByEmail(String email) {
        return this.userRepositoryPort.findByEmail(email);
    }

    @Override
    public String login(String email, String password) {
        UserModel user = this.findByEmail(email);
        if(user == null || !passwordEncoderServicePort.matches(password, user.getPassword()))
            throw new InvalidCredentialsException("Credenciais inválidas");

        return tokenServicePort.generateToken(user);
    }

    @Override
    public void withdrawBalance(String id, Integer balance) {
        UserModel user = userRepositoryPort.findById(Long.parseLong(id));
        if(Objects.isNull(user))
            throw new UserNotFoundException("Usuario não encontrado");

        UserModel userSubtract = subtract(user, balance);
        userRepositoryPort.saveUser(userSubtract);
    }

    private UserModel subtract(UserModel userModel, Integer balanceSubtracted) {
        Integer userBalance = userModel.getBalance();
        userBalance = userBalance - balanceSubtracted;

        if(userBalance < 0)
            throw new InvalidBalanceException("Saldo não pode ser menor que 0");

        userModel.setBalance(userBalance);
        return userModel;
    }
};
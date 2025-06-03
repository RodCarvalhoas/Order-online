package com.order_online.user_service.adapter.input.controllers;

import com.order_online.user_service.adapter.input.transport.user.CreateUserRequest;
import com.order_online.user_service.adapter.input.transport.user.CreateUserResponse;
import com.order_online.user_service.adapter.input.transport.user.LoginRequest;
import com.order_online.user_service.adapter.input.transport.user.LoginResponse;
import com.order_online.user_service.adapter.utils.UserMapper;
import com.order_online.user_service.domain.model.UserModel;
import com.order_online.user_service.port.input.UserServicePort;
import com.order_online.user_service.port.transport.CreateUserResult;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequestMapping("/api/v1/user")
@RestController
public class UserController {

    @Autowired
    private UserServicePort userServicePort;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@Valid @RequestBody CreateUserRequest request) {
        CreateUserResult userCreated = this.userServicePort.saveUser(userMapper.toDomain(request));
        URI uri = ServletUriComponentsBuilder.fromPath("/{id}").buildAndExpand(userCreated.id()).toUri();

        return ResponseEntity.created(uri).body(new CreateUserResponse(userCreated.tokenJWT()));
    }
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest request) {
        String token = this.userServicePort.login(request.email(), request.password());

        return ResponseEntity.ok(new LoginResponse(token));
    }

}

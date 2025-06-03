package com.order_online.user_service.infra.security.services;

import com.order_online.user_service.adapter.utils.UserMapper;
import com.order_online.user_service.port.input.UserServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserServicePort userServicePort;

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userMapper.toEntity(userServicePort.findByEmail(email));
    }
}

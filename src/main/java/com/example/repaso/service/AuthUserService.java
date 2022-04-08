package com.example.repaso.service;

import com.example.repaso.dto.AuthUserDTO;
import com.example.repaso.dto.TokenDTO;
import com.example.repaso.entity.AuthUser;
import com.example.repaso.repository.AuthUserRepository;
import com.example.repaso.security.JWTProvider;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AuthUserService {
    @Autowired
    AuthUserRepository authUserRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JWTProvider jwtProvider;

    public AuthUser save(AuthUserDTO dto) {
        Optional<AuthUser> user = authUserRepository.findByUserName(dto.getUserName());
        if (!user.isPresent()) {
            return null;
        }
        String password = passwordEncoder.encode(dto.getPassword());
        AuthUser authUser = new AuthUser();
        authUser.setUserName(dto.getUserName());
        authUser.setPassword(password);
        return authUserRepository.save(authUser);

    }

    public TokenDTO login(AuthUserDTO dto) {
        Optional<AuthUser> user = authUserRepository.findByUserName(dto.getUserName());
        if (!user.isPresent()) {
            return null;
        }
        if (passwordEncoder.matches(dto.getPassword(), user.get().getPassword())) {
            return new TokenDTO(jwtProvider.createToken(user.get()));
        }
        return null;
    }

    public TokenDTO validate(String token){
        if(!jwtProvider.validate(token)){
            return null;
        }
        String username = jwtProvider.getUserNameFromToken(token);
        if (!authUserRepository.findByUserName(username).isPresent()){
            return null;
        }
        return new TokenDTO(token);
    }
}

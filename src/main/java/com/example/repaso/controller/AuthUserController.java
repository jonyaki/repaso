package com.example.repaso.controller;

import com.example.repaso.dto.AuthUserDTO;
import com.example.repaso.dto.TokenDTO;
import com.example.repaso.entity.AuthUser;
import com.example.repaso.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    AuthUserService authUserService;
    @PostMapping("/login")
    public ResponseEntity<TokenDTO> login (@RequestBody AuthUserDTO dto){
        TokenDTO tokenDTO= authUserService.login(dto);
        if(tokenDTO ==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tokenDTO);
    }
    @PostMapping("/validate")

    public ResponseEntity<TokenDTO> validate (@RequestParam String token){
        TokenDTO tokenDTO= authUserService.validate(token);
        if(tokenDTO ==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(tokenDTO);
    }
    @PostMapping("/create")

    public ResponseEntity<AuthUser> create (@RequestBody AuthUserDTO dto){
        AuthUser authUser = authUserService.save(dto);
        if(authUser==null){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(authUser);

    }
}

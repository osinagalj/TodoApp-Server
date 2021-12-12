package com.todoList.app.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.todoList.app.security.dto.JwtDto;
import com.todoList.app.security.dto.LoginUser;
import com.todoList.app.security.dto.NewUser;
import com.todoList.app.security.entity.Message;
import com.todoList.app.security.entity.Role;
import com.todoList.app.security.entity.User;
import com.todoList.app.security.enums.RoleName;
import com.todoList.app.security.jwt.JwtProvider;
import com.todoList.app.security.service.RoleService;
import com.todoList.app.security.service.UserService;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    JwtProvider jwtProvider;
    

    @PostMapping("/newUser")
    public ResponseEntity<?> newUser(@Valid @RequestBody NewUser newUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("wrong fields or invalid email"), HttpStatus.BAD_REQUEST);
        if(userService.existsByUsername(newUsuario.getUsername()))
            return new ResponseEntity(new Message("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        User usuario =
                new User(newUsuario.getName(), newUsuario.getUsername(),
                        passwordEncoder.encode(newUsuario.getPassword()));
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getByRolNombre(RoleName.ROLE_USER).get());
        if(newUsuario.getRoles().contains("admin"))
            roles.add(roleService.getByRolNombre(RoleName.ROLE_ADMIN).get());
        usuario.setRoles(roles);
        userService.save(usuario);
        return new ResponseEntity(new Message("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUsuario, BindingResult bindingResult){
        if(bindingResult.hasErrors())
            return new ResponseEntity(new Message("campos mal puestos"), HttpStatus.BAD_REQUEST);
        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUsuario.getUsername(), loginUsuario.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails)authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
    
}

package com.github.juliherms.userservice.controller;

import com.github.juliherms.userservice.dto.UserDTO;
import com.github.juliherms.userservice.entity.User;
import com.github.juliherms.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("all")
    public Flux<UserDTO> all(){
        return this.service.all();
    }

    @GetMapping("{id}")
    public Mono<ResponseEntity<UserDTO>> getUserById(@PathVariable Integer id){
        return this.service.getUserById(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<UserDTO> createUser(@RequestBody Mono<UserDTO> userDTOMono){
        return this.service.createUser(userDTOMono);
    }

    @PutMapping("{id}")
    public Mono<ResponseEntity<UserDTO>> updateUser(@PathVariable Integer id, @RequestBody Mono<UserDTO> userDTOMono){
        return this.service.updateUser(id,userDTOMono)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public Mono<Void> deleteUser(@PathVariable Integer id){
        return this.service.deleteUser(id);
    }
}

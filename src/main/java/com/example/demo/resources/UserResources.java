package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(value = "/users" )
public class UserResources {

  @Autowired
  private UserService service;


  /*@GetMapping
  public ResponseEntity<List<User>> findAll() {
    User hamart = new User("1", "Hamart Rony", "hamart@mail.com");
    User hanna = new User("2", "Hanna Alves", "hanna@mail.com");
    List<User> users = new ArrayList<>();
    users.addAll(Arrays.asList(hamart, hanna));
    return ResponseEntity.ok().body(users);
  }*/

  @GetMapping
  public ResponseEntity<List<User>> findAll() {
    List<User> users = service.find();
    return ResponseEntity.ok().body(users);
  }
  
}

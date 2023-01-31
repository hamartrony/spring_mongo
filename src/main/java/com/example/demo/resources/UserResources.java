package com.example.demo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.UserDTO;
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
  public ResponseEntity<List<UserDTO>> findAll() {
    List<User> users = service.find();
    List<UserDTO> listDto = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    return ResponseEntity.ok().body(listDto);
  }


  @RequestMapping(value="/{id}", method=RequestMethod.GET)
  public ResponseEntity<UserDTO> findById(@PathVariable String id) {
    User user = service.findById(id);
    return ResponseEntity.ok().body(new UserDTO(user));
  }
  
}

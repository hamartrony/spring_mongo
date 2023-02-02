package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.User;
import com.example.demo.exception.ObjNotFound;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

  @Autowired
  private UserRepository repo;

  public List<User> find() {
    return repo.findAll();
  }

  public User findById(String id) {
    Optional<User> obj = repo.findById(id);
    return obj.orElseThrow(() -> new ObjNotFound("Objeto nao identificado"));

  }

  public User insert(User obj) {
    return repo.insert(obj);
  }

  public void delete(String id) {
    findById(id);
    repo.deleteById(id);
  }

  public User update(User obj) {
    User newObj = findById(obj.getId());
    updateData(newObj, obj);
    return repo.save(newObj);


  }

  private void updateData(User newObj, User obj) {
    if (obj.getName() != null) {
      newObj.setName(obj.getName());
    }
    if (obj.getEmail() != null) {
      
      newObj.setEmail(obj.getEmail());
    }
  }
  
  



  
}

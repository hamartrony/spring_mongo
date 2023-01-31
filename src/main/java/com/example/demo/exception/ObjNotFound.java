package com.example.demo.exception;

public class ObjNotFound extends RuntimeException {
  private static final long serialVersionUID = 1L;
  public ObjNotFound(String msg) {
    super(msg);
  }
  
}

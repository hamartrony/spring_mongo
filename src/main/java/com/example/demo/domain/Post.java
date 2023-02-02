package com.example.demo.domain;

import org.springframework.data.annotation.Id;

public class Post implements Serializable {

  @Id
  private String id;
  private Date date;
  private String title;
  private String body;

  public Post() {

  }

  public Post(String id, Date date, String title, String body) {
    this.id = id;
    this.date = date;
    this.title = title;
    this.body = body;
  }
  
  

  
}

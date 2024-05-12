package com.example.advanced.design.composite.basic;

import lombok.Getter;

@Getter
public class File implements Component {

  private String name;

  public File(String name) {
    this.name = name;
  }

  @Override
  public void operation() {
    System.out.println("""
        [%s] (file)""".formatted(this.name));
  }
}

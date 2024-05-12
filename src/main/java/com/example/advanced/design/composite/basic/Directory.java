package com.example.advanced.design.composite.basic;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Directory implements Component{

  public Directory(String name) {
    this.name = name;
  }

  List<Component> components = new ArrayList<>();
  private String name;

  public void add(Component c) {
    this.components.add(c);
  }

  public void addAll(Component... c) {
    for (Component component : c) {
      this.components.add(component);
    }
  }

  public void remove(Component c) {
    this.components.remove(c);
  }

  public List<Component> getChild() {
    return this.components;
  }

  @Override
  public void operation() {
    System.out.println("""
        [%s] (directory)""".formatted(this.name));

    for (Component component : components) {
      component.operation();
    }
  }

}

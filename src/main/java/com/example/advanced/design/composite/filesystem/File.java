package com.example.advanced.design.composite.filesystem;

import lombok.Getter;

@Getter
public class File implements Node {
  private String name;
  private int size;
  private String type;

  public File(String name, int size, String type) {
    this.name = name;
    this.size = size;
    this.type = type;
  }

  @Override
  public void print() {
    this.print("");
  }

  @Override
  public void print(String str) {
    System.out.println(str + "\uD83D\uDCDC" + name + " (" + size + "kb)");
  }

  @Override
  public int getSize() {
    return size;
  }
}

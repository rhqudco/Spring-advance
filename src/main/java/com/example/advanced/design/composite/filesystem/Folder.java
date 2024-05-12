package com.example.advanced.design.composite.filesystem;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class Folder implements Node {
  private String name;
  private List<Node> list;
  private String type;

  public Folder(String name, String type) {
    this.name = name;
    list = new ArrayList<>();
    this.type = type;
  }

  public void add(Node... node) {
    for (Node n : node) {
      list.add(n);
    }
  }

  @Override
  public void print() {
    this.print("");
  }

  @Override
  public void print(String str) {
    int size = getSize(); // 폴더가 담고 있는 모든 파일에 대한 용량 합산

    System.out.println(str + "\uD83D\uDCC2" + name + " (" + size + "kb)");

    for (Node node : list) {
      // Folder 일 경우 재귀 동작
      node.print(str + "    "); // 인자로 공백문자를 할당하여 indent 처리
    }
  }

  @Override
  public int getSize() {
    int sum = 0;
    for (Node node : list) {
      sum += node.getSize();
    }
    return sum;
  }
}

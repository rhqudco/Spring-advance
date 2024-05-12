package com.example.advanced.design.composite.basic;

public class Main {

  public static void main(String[] args) {
    // 1. 최상위 폴더
    Directory root = new Directory("root");

    // 2. 최상위 폴더 하위에 존재 하는 폴더 및 파일
    File fileInRoot = new File("root in file");
    Directory subDirectory = new Directory("sub directory");

    // 3. 최상위에 등록
    root.addAll(fileInRoot, subDirectory);

    // 4. directoryInRoot에 등록할 파일 생성
    File fileInSubDirectory1 = new File("sub in file 1");
    File fileInSubDirectory2 = new File("sub in file 2");
    File fileInSubDirectory3 = new File("sub in file 3");

    // 5. SubDirectory에 파일 등록
    subDirectory.addAll(fileInSubDirectory1, fileInSubDirectory2, fileInSubDirectory3);

    // 6. 내부 파일 확인
    root.operation();
  }

}

package com.example.advanced.design.composite.filesystem;

public class Client {

  public static void main(String[] args) {
    Folder root = new Folder("conf", "folder");

    File info = new File("info.json", 10, "file");
    Folder source = new Folder("source", "folder");
    File sourceConfSso = new File("source_sso.conf", 10, "file");
    File sourceConfForti = new File("source_forti.conf", 10, "file");
    File sourceConfTennant = new File("source_tennant.conf", 10, "file");
    source.add(sourceConfSso, sourceConfForti, sourceConfTennant);

    Folder filter = new Folder("filter", "folder");
    File filterConfSso = new File("filter_sso.conf", 10, "file");
    File filterConfForti = new File("filter_forti.conf", 10, "file");
    filter.add(filterConfSso, filterConfForti);

    Folder match = new Folder("match", "folder");
    File matchConfSso = new File("match_sso.conf", 10, "file");
    File matchConfBilling = new File("match_billing.conf", 10, "file");
    match.add(matchConfSso, matchConfBilling);

    root.add(info, source, filter, match);

    // 전체 dir 출력
    root.print();
  }

}

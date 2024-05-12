package com.example.advanced.design.composite.filejson;

public class Main {
  public static void main(String[] args) {
    Directory root = new Directory("conf", "dir");

    File info = new File("info.json", "file");
    Directory source = new Directory("source", "dir");
    File sourceConfSso = new File("source_sso.conf", "file");
    File sourceConfForti = new File("source_forti.conf", "file");
    File sourceConfTennant = new File("source_tennant.conf", "file");
    source.add(sourceConfSso, sourceConfForti, sourceConfTennant);

    Directory filter = new Directory("filter", "dir");
    File filterConfSso = new File("filter_sso.conf", "file");
    File filterConfForti = new File("filter_forti.conf", "file");
    filter.add(filterConfSso, filterConfForti);

    Directory match = new Directory("match", "dir");
    File matchConfSso = new File("match_sso.conf", "file");
    File matchConfBilling = new File("match_billing.conf", "file");
    match.add(matchConfSso, matchConfBilling);

    Directory innerMatch = new Directory("innerMatch", "dir");
    File innerMatchForti = new File("inner_match_forti.conf", "file");
    innerMatch.add(innerMatchForti);
    match.add(innerMatch);

    root.add(info, source, filter, match);

    // 전체 dir 출력
    System.out.println(root.toJson().toJSONString());
  }
}

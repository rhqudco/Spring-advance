package com.example.advanced.design.composite.filejson;

import org.json.simple.JSONObject;

public interface Component {
  void add(Component... component);
  void remove(Component component);
  JSONObject toJson();
  String getType();
  String getName();
}

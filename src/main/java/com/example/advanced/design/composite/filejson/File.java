package com.example.advanced.design.composite.filejson;

import org.json.simple.JSONObject;

public class File implements Component {
  private String name;
  private String type;

  public File(String name, String type) {
    this.name = name;
    this.type = type;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getType() {
    return this.type;
  }

  @Override
  public void add(Component... component) {
    throw new UnsupportedOperationException();
  }

  @Override
  public void remove(Component component) {
    throw new UnsupportedOperationException();
  }

  @Override
  public JSONObject toJson() {
    JSONObject obj = new JSONObject();
    obj.put("name", name);
    return obj;
  }
}

package com.example.advanced.design.composite.filejson;

import java.util.ArrayList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Directory implements Component {
  private String name;
  private List<Component> child = new ArrayList<>();
  private String type;

  public Directory(String name, String type) {
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
    for (Component c : component) {
      child.add(c);
    }
  }

  @Override
  public void remove(Component component) {
    child.remove(component);
  }

  @Override
  public JSONObject toJson() {
    JSONObject obj = new JSONObject();

    for (Component component : child) {
      if (component instanceof File) {
        obj.put(component.getName(), "file");
      } else {
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(component.toJson());
        obj.put(component.getName(), jsonArray);
      }
    }

    return obj;
  }

}

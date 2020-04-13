package com.forezp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {


  public static void main(String[] args) {

    List<Map<String, Object>> list1 = new ArrayList<>();
    List<Map<String, Object>> list2 = new ArrayList<>();
    Map<String, Object> objectMap = new HashMap<>();
    objectMap.put("id", "4");
    objectMap.put("name", "tudou");

    Map<String, Object> objectMap1 = new HashMap<>();
    objectMap1.put("id", "5");
    objectMap1.put("name", "xigua");

    Map<String, Object> objectMap2 = new HashMap<>();
    objectMap2.put("id", "5");
    objectMap2.put("price", "2.0");
    Map<String, Object> objectMap3 = new HashMap<>();

    objectMap3.put("id", "6");
    objectMap3.put("price", "7");
    list1.add(objectMap);
    list1.add(objectMap1);

    list2.add(objectMap3);
    list2.add(objectMap2);


    List<Map<String, Object>> result = merge(list1, list2, "id");
    for (int j = 0; j < result.size(); j++) {
      System.out.println(result.get(j).toString());
    }
  }

  private static List<Map<String, Object>> merge(List<Map<String, Object>> List1, List<Map<String, Object>> List2, String filedName) {
    Map<String, Map<String, Object>> map = new HashMap<>();
    int len1 = List1.size();
    int len2 = List2.size();

    for (int i = 0; i < len1; i++) {
      Map<String, Object> tmpMap = List1.get(i);
      map.put(tmpMap.get(filedName).toString(), tmpMap);
    }

    for (int i = 0; i < len2; i++) {
      Map<String, Object> tmp = List2.get(i);
      if (map.containsKey(tmp.get(filedName))) {
        Map<String, Object> map1 = map.get(tmp.get(filedName));
        map1.putAll(tmp);
      }
    }
    return List1;
  }

}

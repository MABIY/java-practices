package com.lh.annotationprocessor.value;

import java.lang.String;
import java.util.List;
import lombok.Data;

@Data
public class OrderedPairNew<K, V extends String> {
  private List<K> b;

  private K key;

  private V value;

  private List<String> a;

  public OrderedPairNew create() {
    OrderedPairNew entity = new OrderedPairNew();
    entity.setB(b);
    entity.setKey(key);
    entity.setValue(value);
    entity.setA(a);
    return entity;
  }

  public OrderedPairNew assign(OrderedPairNew entity) {
    entity.setB(b);
    entity.setKey(key);
    entity.setValue(value);
    entity.setA(a);
    return entity;
  }

  public OrderedPairNew patch(OrderedPairNew entity) {
    if (b != null ) {
      entity.setB(b);
    }
    if (key != null ) {
      entity.setKey(key);
    }
    if (value != null ) {
      entity.setValue(value);
    }
    if (a != null ) {
      entity.setA(a);
    }
    return entity;
  }
}

package com.redis.om.spring.repository.query;

import com.redis.om.spring.metamodel.MetamodelField;

import java.io.Serial;
import java.util.Arrays;
import java.util.List;

public class Sort extends org.springframework.data.domain.Sort {

  protected Sort(List<Order> orders) {
    super(orders);
  }
  
  /**
   * Creates a new {@link org.springframework.data.domain.Sort} for the given {@link Order}s
   * use {@link com.redis.om.spring.metamodel.MetamodelField}
   *
   * @param direction must not be {@literal null}.
   * @param fields must not be {@literal null}.
   * @return a Spring Sort object
   */
  public static org.springframework.data.domain.Sort by(Direction direction, MetamodelField<?, ?>... fields) {
    String[] properties = Arrays.stream(fields).map(MetamodelField::getSearchAlias).toArray(String[]::new);
    return org.springframework.data.domain.Sort.by(direction, properties);
  }

  @Serial private static final long serialVersionUID = 7789210988714363618L;

}

package domain;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-13T11:10:49")
@StaticMetamodel(ProductEntity.class)
public class ProductEntity_ { 

    public static volatile SingularAttribute<ProductEntity, BigDecimal> unitPrice;
    public static volatile SingularAttribute<ProductEntity, Long> unitsInStock;
    public static volatile SingularAttribute<ProductEntity, Long> unitsInOrder;
    public static volatile SingularAttribute<ProductEntity, String> condition;
    public static volatile SingularAttribute<ProductEntity, String> productId;
    public static volatile SingularAttribute<ProductEntity, String> name;
    public static volatile SingularAttribute<ProductEntity, String> description;
    public static volatile SingularAttribute<ProductEntity, Boolean> discontinued;
    public static volatile SingularAttribute<ProductEntity, Long> id;
    public static volatile SingularAttribute<ProductEntity, String> category;
    public static volatile SingularAttribute<ProductEntity, String> manufacturer;

}
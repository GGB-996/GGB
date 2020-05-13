package com.example.demo;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository("CRUDDao1")
@Mapper
public interface CRUDDao {
    @Select("select * from product")
    List<Product> getAllProduct();
    @Select("select * from product where productName =#{productName}")
    Product getProductByName(@Param("productName") String productName);
    @Insert("insert into product(pid,productName,unitPrice,total) values(#{pid},#{productName},#{unitPrice},#{total})")
    int addProduct(Product product);
    @Update("update product set productName=#{productName},unitPrice=#{unitPrice},total=#{total} where pid=#{pid}")
    int updateProduct(Product product);
    @Delete("delete from product where id=#{pid}")
    int deleteProduct(@Param("id") Integer pid);
}

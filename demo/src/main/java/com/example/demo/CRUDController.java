package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CRUDController {
    @Autowired
    private CRUDService crudService;

    @GetMapping("/getProductByName/{name}")
    public Result getProductByName(@PathVariable("name")String productName){
        Product product=crudService.getProductByName(productName);
        return Result.success().add("product",product);
    }

    @GetMapping("/getAllProduct")
    public Result getAllProduct(){
        List<Product> products=crudService.getAllProduct();
        return Result.success().add("product",products);
    }

    @GetMapping("/addProduct")
    public Result addProduct(){
        Product product=new Product();
        product.setPid(2);
        product.setProductName("молоко");
        product.setUnitPrice(100);
        product.setTotal(5000);
        crudService.addProduct(product);
        return Result.success();
    }

    @GetMapping("/updateProduct")
    public Result updateProduct(){
        Product product=new Product();
        product.setPid(2);
        product.setProductName("сыр");
        product.setUnitPrice(30);
        product.setTotal(2000);
        crudService.updateProduct(product);
        return Result.success();
    }

    @GetMapping("/deleteUser/{id}")
    public Result deleteProduct(@PathVariable("id") Integer pid){
        crudService.deleteProduct(pid);
        return Result.success();
    }

}

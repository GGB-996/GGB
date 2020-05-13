package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CRUDService implements CRUDDao {

    @Qualifier("CRUDDao1")
    @Autowired
    private CRUDDao crudDao;
    @Override
    public List<Product> getAllProduct() {
        return crudDao.getAllProduct();
    }

    @Override
    public Product getProductByName(String productName) {
        return crudDao.getProductByName(productName);
    }

    @Override
    public int addProduct(Product product) {
        return crudDao.addProduct(product);
    }

    @Override
    public int updateProduct(Product product) {
        return crudDao.updateProduct(product);
    }

    @Override
    public int deleteProduct(Integer pid) {
        return crudDao.deleteProduct(pid);
    }
}

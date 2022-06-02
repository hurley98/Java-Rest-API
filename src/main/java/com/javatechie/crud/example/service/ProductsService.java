package com.javatechie.crud.example.service;

import com.javatechie.crud.example.GenericRepository;
import com.javatechie.crud.example.entities.Tables;
import com.javatechie.crud.example.entities.tables.pojos.Cart;
import com.javatechie.crud.example.entities.tables.pojos.Products;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService implements GenericRepository<Products> {
    @Autowired
    DSLContext context;

    //return 1 if added
    @Override
    public int add(Products product) {
        return context.insertInto(Tables.PRODUCTS, Tables.PRODUCTS.PRODUCTNAME, Tables.PRODUCTS.UNITPRICE,
                Tables.PRODUCTS.UNIT).values(product.getProductname(), product.getUnitprice(), product.getUnit()
        ).returning().execute();
    }

    @Override
    public List<Products> findAll() {
        return context.select().from(Tables.PRODUCTS).fetchInto(Products.class);
    }

    @Override
    public Products findById(int id) {
        List<Products> list = context.select()
                .from(Tables.PRODUCTS)
                .where(Tables.PRODUCTS.PRODUCTID.eq(id))
                .fetchInto(Products.class);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    //return 1 if updated
    @Override
    public int update(Products product) {
        return context.update(Tables.PRODUCTS)
                .set(Tables.PRODUCTS.PRODUCTNAME, product.getProductname())
                .set(Tables.PRODUCTS.UNITPRICE, product.getUnitprice())
                .set(Tables.PRODUCTS.UNIT, product.getUnit())
                .where(Tables.PRODUCTS.PRODUCTID.eq(product.getProductid()))
                .execute();
    }


    //return 1 if deleted
    @Override
    public int deleteById(int id) {
        return context.delete(Tables.PRODUCTS)
                .where(Tables.PRODUCTS.PRODUCTID.eq(id))
                .execute();
    }


}
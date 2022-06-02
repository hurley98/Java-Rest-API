package com.javatechie.crud.example.service;

import com.javatechie.crud.example.GenericRepository;
import com.javatechie.crud.example.entities.Tables;
import com.javatechie.crud.example.entities.tables.pojos.ProductToCart;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductToCartService implements GenericRepository<ProductToCart> {
    @Autowired
    DSLContext context;

    //return 1 if added
    @Override
    public int add(ProductToCart productToCart) {
        return context.insertInto(Tables.PRODUCT_TO_CART, Tables.PRODUCT_TO_CART.CARTID,
                        Tables.PRODUCT_TO_CART.PRODUCTID, Tables.PRODUCT_TO_CART.PRODUCTQUANTITY
                )
                .values(productToCart.getCartid(), productToCart.getProductid(),
                        productToCart.getProductquantity())
                .returning().execute();
    }

    //finds all products in the cart
    @Override
    public List<ProductToCart> findAll() {
        return context.select().from(Tables.PRODUCT_TO_CART).
                fetchInto(ProductToCart.class);
    }

    //view cart content by id
    public ProductToCart findById(int id) {
        return context.select()
                .from(Tables.PRODUCT_TO_CART)
                .where(Tables.PRODUCT_TO_CART.CARTID.eq(id))
                .fetchInto(ProductToCart.class).get(0);
    }

    //update a product in a cart, return 1 if updated
    @Override
    public int update(ProductToCart productToCart) {
        return context.update(Tables.PRODUCT_TO_CART)
                .set(Tables.PRODUCT_TO_CART.PRODUCTID, productToCart.getProductid())
                .set(Tables.PRODUCT_TO_CART.CARTID, productToCart.getCartid())
                .set(Tables.PRODUCT_TO_CART.PRODUCTQUANTITY, productToCart.getProductquantity())
                .where(Tables.PRODUCT_TO_CART.CARTID.eq(productToCart.getCartid()))
                .execute();
    }


    public String findTotalSumOfCart(int id) {
        int counter = 0;
        List<Integer> quantity = context.select(Tables.PRODUCT_TO_CART.PRODUCTQUANTITY)
                .from(Tables.PRODUCT_TO_CART)
                .where(Tables.PRODUCT_TO_CART.CARTID.eq(id)).fetch(0, int.class);

        List<Double> unitPrice = context.select(Tables.PRODUCTS.UNITPRICE)
                .from(Tables.PRODUCT_TO_CART).join(Tables.PRODUCTS)
                .on(Tables.PRODUCT_TO_CART.PRODUCTID.eq(Tables.PRODUCTS.PRODUCTID))
                .where(Tables.PRODUCT_TO_CART.CARTID.eq(id)).fetch(0, double.class);

        double total = 0.0;
        for (int i = 0; i < quantity.size(); i++) {
            counter++;
            total += quantity.get(i) * unitPrice.get(i);
        }

        return "The total sum of the " + counter + " products in the cart is " + total;
    }


    @Override
    public int deleteById(int id) {
        return context.delete(Tables.PRODUCT_TO_CART)
                .where(Tables.PRODUCT_TO_CART.CARTID.eq(id))
                .execute();
    }
}
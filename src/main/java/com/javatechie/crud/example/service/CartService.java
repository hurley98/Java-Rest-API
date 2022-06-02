package com.javatechie.crud.example.service;

import com.javatechie.crud.example.GenericRepository;
import com.javatechie.crud.example.entities.Tables;
import com.javatechie.crud.example.entities.tables.pojos.Cart;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements GenericRepository<Cart> {
    @Autowired
    DSLContext context;

    //return 1 if cart added
    @Override
    public int add(Cart cart) {
        return context.insertInto(Tables.CART, Tables.CART.ORDERDATE).values(cart.getOrderdate())
                .returning().execute();
    }

    @Override
    public List<Cart> findAll() {
        return context.select().from(Tables.CART).fetchInto(Cart.class);
    }


    @Override
    public Cart findById(int id) {
        List<Cart> list = context.select()
                .from(Tables.CART)
                .where(Tables.CART.CARTID.eq(id))
                .fetchInto(Cart.class);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
    }

    //return 1 if cart updated
    @Override
    public int update(Cart cart) {
        return context.update(Tables.CART)
                .set(Tables.CART.ORDERDATE, cart.getOrderdate())
                .where(Tables.CART.CARTID.eq(cart.getCartid()))
                .execute();
    }

    //return 1 if cart deleted
    @Override
    public int deleteById(int id) {
        return context.delete(Tables.CART)
                .where(Tables.CART.CARTID.eq(id))
                .execute();
    }

}